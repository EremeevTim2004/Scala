package objsets

import PostReader._
import objsets.PostSetInterface

class Post(val user: String, val text: String, val reposts: Int):
  override def toString: String =
    "User: " + user + "\n" +
    "Text: " + text + " [" + reposts + "]"

  def links(keywords: List[String]): Boolean = keywords.exists(keyword => text.contains(keyword))

abstract class PostSet extends PostSetInterface:
  def filter(p: Post => Boolean): PostSet = filterAcc(p, new Empty)

  def filterAcc(p: Post => Boolean, acc: PostSet): PostSet

  def union(that: PostSet): PostSet

  def isEmpty: Boolean

  def mostReposted: Post

  def descendingByRepost: PostList = {
    def loop(in: PostSet, ts: PostList): PostList = {
      if (in.isEmpty) ts
      else {
        val mostPopularTweet = in.mostReposted
        new Cons(mostPopularTweet, loop(in.remove(mostPopularTweet), ts))
      }
    }
    loop(this, Nil)
  }

  def links(keywords: List[String]): PostSet = filter(x => x.links(keywords))

  def incl(post: Post): PostSet

  def remove(post: Post): PostSet

  def contains(post: Post): Boolean

  def foreach(f: Post => Unit): Unit

class Empty extends PostSet:
  def filterAcc(p: Post => Boolean, acc: PostSet): PostSet = new Empty

  def union(that: PostSet): PostSet = that

  def mostReposted: Post = throw new NoSuchElementException

  def isEmpty = true

  def contains(post: Post): Boolean = false

  def incl(post: Post): PostSet = NonEmpty(post, Empty(), Empty())

  def remove(post: Post): PostSet = this

  def foreach(f: Post => Unit): Unit = ()

class NonEmpty(elem: Post, left: PostSet, right: PostSet) extends PostSet:
  def filterAcc(p: Post => Boolean, acc: PostSet): PostSet = {
    val l_el = left.filterAcc(p, acc)
    val r_el = right.filterAcc(p, acc)
    val lAndr = l_el union r_el
    if(p(elem)) lAndr.incl(elem) else lAndr
  }

  def isEmpty = false

  def union(that: PostSet): PostSet = right.union(left.union(that.incl(elem)))

  def mostReposted: Post = {
    val all = right.union(left);
    val morePopular = all.filter(p => p.reposts > elem.reposts)
    if (morePopular.isEmpty) elem else morePopular.mostReposted
  }

  def contains(x: Post): Boolean =
    if x.text < elem.text then
      left.contains(x)
    else if elem.text < x.text then
      right.contains(x)
    else true

  def incl(x: Post): PostSet =
    if x.text < elem.text then
      NonEmpty(elem, left.incl(x), right)
    else if elem.text < x.text then
      NonEmpty(elem, left, right.incl(x))
    else
      this

  def remove(tw: Post): PostSet =
    if tw.text < elem.text then
      NonEmpty(elem, left.remove(tw), right)
    else if elem.text < tw.text then
      NonEmpty(elem, left, right.remove(tw))
    else
      left.union(right)

  def foreach(f: Post => Unit): Unit =
    f(elem)
    left.foreach(f)
    right.foreach(f)

trait PostList:
  def head: Post
  def tail: PostList
  def isEmpty: Boolean
  def foreach(f: Post => Unit): Unit =
    if !isEmpty then
      f(head)
      tail.foreach(f)

object Nil extends PostList:
  def head = throw java.util.NoSuchElementException("head of EmptyList")
  def tail = throw java.util.NoSuchElementException("tail of EmptyList")
  def isEmpty = true

class Cons(val head: Post, val tail: PostList) extends PostList:
  def isEmpty = false

object GoogleVsApple:
  val google = List("android", "Android", "galaxy", "Galaxy", "nexus", "Nexus")
  val apple = List("ios", "iOS", "iphone", "iPhone", "ipad", "iPad")

  lazy val googlePosts: PostSet = PostReader.allPosts.links(google)
  lazy val applePosts: PostSet = PostReader.allPosts.links(apple)
  lazy val trending: PostList = googlePosts.union(applePosts).descendingByRepost

object Main extends App:
  GoogleVsApple.trending foreach println

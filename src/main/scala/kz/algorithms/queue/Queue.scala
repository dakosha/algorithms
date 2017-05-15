package kz.algorithms.queue

import kz.algorithms.base.Node

class Queue[T] {

  private var last: Node[T] = null

  def empty: Boolean = last == null

  def enQueue(value: T) = {
    if (last==null)
      last = Node(value)
    else {
      var node = last
      while (node.next!=null)
        node = node.next
      node.next = Node(value)
    }
  }

  def deQueue: T = {
    if (last==null)
      throw new NoSuchElementException
    else {
      val res = last.value
      last = last.next
      res
    }
  }

  override def toString = last.toString

}

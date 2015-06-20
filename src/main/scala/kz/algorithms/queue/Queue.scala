package kz.algorithms.queue

import kz.algorithms.base.Node

/**
 * Created by Alina on 20.06.15.
 */
class Queue {

  private var last: Node = null

  def empty: Boolean = last == null

  def enQueue(value: Int) = {
    if (last==null)
      last = Node(value)
    else {
      var node = last
      while (node.next!=null)
        node = node.next
      node.next = Node(value)
    }
  }

  def deQueue: Int = {
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

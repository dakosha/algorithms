package kz.algorithms.stack

import java.util.NoSuchElementException

import kz.algorithms.base.Node

/**
 * Created by Alina on 20.06.15.
 */
class Stack [T] {

  private var lastNode: Node[T] = null

  def empty: Boolean = lastNode == null

  def peek: Option[T] = if (lastNode != null) Some(lastNode.value) else None

  def push(value: T) = {
    if (lastNode == null)
      lastNode = Node(value)
    else {
      val node = Node(value)
      node.next = lastNode
      lastNode = node
    }
  }

  def pop: T = {
    if (lastNode == null)
      throw new NoSuchElementException
    val res = lastNode.value
    lastNode = lastNode.next
    res
  }

  override def toString = lastNode.toString

}

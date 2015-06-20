package kz.algorithms.stack

import java.util.NoSuchElementException

import kz.algorithms.base.Node

import scala.util.Success

/**
 * Created by Alina on 20.06.15.
 */
class Stack {

  private var lastNode: Node = null

  def empty: Boolean = lastNode == null

  def peek: Option[Int] = if (lastNode != null) Some(lastNode.value) else None

  def push(value: Int) = {
    if (lastNode == null)
      lastNode = Node(value)
    else {
      val node = Node(value)
      node.next = lastNode
      lastNode = node
    }
  }

  def pop: Int = {
    if (lastNode == null)
      throw new NoSuchElementException
    val res = lastNode.value
    lastNode = lastNode.next
    res
  }

  override def toString = lastNode.toString

}

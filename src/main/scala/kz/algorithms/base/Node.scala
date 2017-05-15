package kz.algorithms.base

case class Node [T] (value: T, var next: Node[T] = null) {

  def addLast(value: T): Node[T] = {
    var n = this
    while (n.next!=null)
      n = n.next
    n.next = Node(value)
    this
  }

  def addFirst(value: T): Node[T] = {
    var n = Node(value)
    n.next = this
    n
  }

  override def toString = {
    this match {
      case null => ""
      case Node(v, n) => n match {
        case null => s"$v"
        case Node(v1, n1) => s"$v->$n"
      }
    }
  }

}
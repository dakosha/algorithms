package kz.algorithms.base

/**
 * Created by Alina on 20.06.15.
 */
case class Node(value: Int, var next: Node = null) {

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
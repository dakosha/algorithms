package leetcode

import scala.util.Random

/**
  * @author Dauren Mussa
  * @since 11/27/17
  */
final class AVLTree {

  private var root: Option[Node] = None

  /*
  Method adds the value into the tree
  */
  def add(value: Int): Option[Node] = {

    def addInternal(node: Node, value: Int): Option[Node] = {
      node.value match {
        case v if v > value => {
          node.left match {
            case Some(n) => {
              return addInternal(n, value)
            }
            case None => {
              node.left = Some(new Node(value, node.level + 1))
              return node.left
            }
          }
        }
        case v if v < value => {
          node.right match {
            case Some(n) => {
              return addInternal(n, value)
            }
            case None => {
              node.right = Some(new Node(value, node.level + 1))
              return node.right
            }
          }
        }
        case v if v == value => {
          node.count += 1
          return Some(node)
        }
      }
    }

    root match {
      case Some(n) => {
        return addInternal(n, value)
      }
      case None => {
        root = Some(new Node(value))
        return root
      }
    }
  }

  /*
  Method finds the value in the Tree
   */
  def find(value: Int): Option[Node] = {

    def findInternal(node: Node, value: Int): Option[Node] = {
      node.value match {
        case v if v > value => {
          node.left match {
            case Some(n) => {
              return findInternal(n, value)
            }
          }
        }
        case v if v < value => {
          node.right match {
            case Some(n) => {
              return findInternal(n, value)
            }
          }
        }
        case v if v == value => {
          return Some(node)
        }
      }

      return None
    }

    root match {
      case Some(n) => {
        return findInternal(n, value)
      }
      case None => {
        return None
      }
    }

  }

  private def printTree(node: Option[Node]): String = {
    node match {
      case Some(n) => {
        return "(" + printTree(n.left) + " <= " + n.value + " => " + printTree(n.right) + ")"
      }
      case None => {
        return "Leaf"
      }
    }
  }

  override def toString = {
    printTree(root)
  }

  class Node(var value: Int, var level: Int = 1) {
    var left: Option[Node] = None
    var right: Option[Node] = None
    var count: Int = 1
    var height: Int = 0

    override def toString = s"Node(count=$count, value=$value, level=$level)"
  }

}

object Main {
  def main(args: Array[String]): Unit = {
    implicit def intWithTimes(n: Int) = new {
      def times(f: => Unit) = 1 to n foreach { _ => f }
    }

    val aVLTree: AVLTree = new AVLTree

    aVLTree.add(4)
    aVLTree.add(2)
    aVLTree.add(6)
    aVLTree.add(1)
    aVLTree.add(3)
    aVLTree.add(5)
    aVLTree.add(7)

    println(aVLTree.find(5).get.toString)


    println(aVLTree.toString)
  }
}

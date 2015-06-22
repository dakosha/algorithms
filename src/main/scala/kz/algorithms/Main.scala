package kz.algorithms

import kz.algorithms.base.Node
import kz.algorithms.graph.Graph
import kz.algorithms.queue.Queue
import kz.algorithms.stack.Stack
import kz.algorithms.tree.{TreeHelper, TreeItem}

/**
 * Created by Alina on 20.06.15.
 */
object Main {

  def main(args: Array[String]) = {

    val tree = TreeHelper.generateTree(Array(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15))
    println(tree)

    var node = tree.left.right.right
    var n = TreeHelper.nextInOrderNode(node)
    println(node.value)
    println(n.value)

    node = tree.left.left.left
    n = TreeHelper.nextInOrderNode(node)
    println(node.value)
    println(n.value)

    node = tree.right.right.right
    n = TreeHelper.nextInOrderNode(node)
    println(node.value)
    println(n.value)

    node = tree.right.left.right
    n = TreeHelper.nextInOrderNode(node)
    println(node.value)
    println(n.value)

    node = tree.left.right.left
    n = TreeHelper.nextInOrderNode(node)
    println(node.value)
    println(n.value)

  }


}

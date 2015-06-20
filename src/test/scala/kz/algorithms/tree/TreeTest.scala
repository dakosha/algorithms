package kz.algorithms.tree

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSuite, FlatSpec}

/**
 * Created by Alina on 20.06.15.
 */
@RunWith(classOf[JUnitRunner])
class TreeTest extends FunSuite {

  test("When inserting ordered array, Tree is always disBalanced") {
    val array = Array(2,3,4,5,6,7)
    var node = TreeItem(1)
    for { value <- array } yield node.insert(value)
    assert(!TreeHelper.isBalanced(node))
  }

  test("When inserting ordered array and balancing tree, Tree is always Balanced") {
    val array = Array(2,3,4,5,6,7)
    var node: TreeNode = TreeItem(1)
    for { value <- array } yield node.insert(value)
    assert(!TreeHelper.isBalanced(node))
    node = TreeHelper.balance(node)
    assert(TreeHelper.isBalanced(node))
  }

}

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
    var node = TreeItem(1, null)
    for { value <- array } yield node.insert(value)
    assert(!TreeHelper.isBalanced(node))
  }

  test("When inserting ordered array and balancing tree, Tree is always Balanced") {
    val array = Array(2,3,4,5,6,7)
    var node: TreeNode = TreeItem(1, null)
    for { value <- array } yield node.insert(value)
    assert(!TreeHelper.isBalanced(node))
    node = TreeHelper.balance(node)
    assert(TreeHelper.isBalanced(node))
  }

  test("In tree, it should return exact value") {
    val tree = TreeHelper.generateTree(Array(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15))

    assert(tree.find(1).value == 1)
    assert(tree.find(3).value == 3)
    assert(tree.find(4).value == 4)
    assert(tree.find(5).value == 5)
    assert(tree.find(6).value == 6)
    assert(tree.find(7).value == 7)
    assert(tree.find(11).value == 11)
  }

  test("In tree, it should return next in-order node") {
    val tree = TreeHelper.generateTree(Array(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15))

    val node1 = tree.left.left.left
    val node3 = tree.left.left.right
    val node4 = tree.left
    val node6 = tree.left.right
    val node7 = tree.left.right.right
    val node8 = tree
    val node11 = tree.right.left.right
    val node12 = tree.right
    val node15 = tree.right.right.right

    assert(TreeHelper.nextInOrderNode(node1).value == 2)
    assert(TreeHelper.nextInOrderNode(node3).value == 4)
    assert(TreeHelper.nextInOrderNode(node4).value == 5)
    assert(TreeHelper.nextInOrderNode(node6).value == 7)
    assert(TreeHelper.nextInOrderNode(node7).value == 8)
    assert(TreeHelper.nextInOrderNode(node8).value == 9)
    assert(TreeHelper.nextInOrderNode(node11).value == 12)
    assert(TreeHelper.nextInOrderNode(node12).value == 13)
    assert(TreeHelper.nextInOrderNode(node15).value == -1)

  }

  test("In tree, it should return common parent for both nodes") {
    val tree = TreeHelper.generateTree(Array(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15))
    assert(TreeHelper.findCommonParent(tree.find(1), tree.find(7)).value == 4)
    assert(TreeHelper.findCommonParent(tree.find(1), tree.find(5)).value == 4)
    assert(TreeHelper.findCommonParent(tree.find(1), tree.find(6)).value == 4)
    assert(TreeHelper.findCommonParent(tree.find(3), tree.find(6)).value == 4)
    assert(TreeHelper.findCommonParent(tree.find(4), tree.find(15)).value == 8)
    assert(TreeHelper.findCommonParent(tree.find(4), tree.find(11)).value == 8)
    assert(TreeHelper.findCommonParent(tree.find(9), tree.find(13)).value == 12)
    assert(TreeHelper.findCommonParent(tree.find(9), tree.find(11)).value == 10)
  }

}

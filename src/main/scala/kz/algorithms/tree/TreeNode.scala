package kz.algorithms.tree

/**
 * Created by Alina on 20.06.15.
 */

trait TreeNode {
  def insert(VAL: Int): TreeNode
  def delete(VAL: Int): TreeNode
  def inOrder: Array[Int]
  def preOrder: Array[Int]
  def postOrder: Array[Int]
}

object Leaf extends TreeNode {
  override def toString = "Leaf"
  override def insert(VAL: Int) = ???
  override def delete(VAL: Int) = ???
  override def inOrder: Array[Int] = Array()
  override def preOrder: Array[Int] = Array()
  override def postOrder: Array[Int] = Array()
}

case class TreeItem(val value: Int,
                    var left: TreeNode = Leaf,
                    var right: TreeNode = Leaf) extends TreeNode {

  override def toString = s"[$left-$value-$right]"

  override def insert(VAL: Int) = {
    if (VAL > value) {
      right match {
        case TreeItem(n, r, l) => right.insert(VAL)
        case Leaf => right = TreeItem(VAL)
      }
    }
    else if (VAL < value) {
      left match {
        case TreeItem(n, r, l) => left.insert(VAL)
        case Leaf => left = TreeItem(VAL)
      }
    }
    this
  }

  override def delete(VAL: Int): TreeNode = {
    if (VAL > value) {
      right match {
        case TreeItem(n, l, r) => {
          if (n == VAL) {
            val nodes = l.inOrder ++ r.inOrder
            right = TreeHelper.generateTree(nodes)
          }
          else {
            right.delete(VAL)
          }
        }
      }
    }
    else if (VAL < value) {
      left match {
        case TreeItem(n, l, r) => {
          if (n==VAL) {
            val nodes = l.inOrder ++ r.inOrder
            left = TreeHelper.generateTree(nodes)
          }
          else {
            left.delete(VAL)
          }
        }
      }
    }
    else {
      val nodes = left.inOrder ++ right.inOrder
      return TreeHelper.generateTree(nodes)
    }
    this
  }

  override def inOrder: Array[Int] = {
    left.inOrder ++ Array(value) ++ right.inOrder
  }

  override def preOrder: Array[Int] = {
    Array(value) ++ left.preOrder ++ right.preOrder
  }

  override def postOrder: Array[Int] = {
    left.postOrder ++ right.postOrder ++ Array(value)
  }

}

object TreeHelper {

  def generateTree(array: Array[Int]) = {

    def generateTree(start: Int, end: Int): TreeNode = {
      if (start == end)
        return Leaf;

      val middle = (start + end) / 2;
      val node = TreeItem(array(middle))

      node.left = generateTree(start, middle)
      node.right = generateTree(middle+1, end)

      node
    }

    generateTree(0, array.length)
  }

  def isBalanced(node: TreeNode): Boolean = {

    def maxDepth(node: TreeNode): Int = node match {
      case Leaf => 0
      case TreeItem(value, left, right) => math.max(maxDepth(left), maxDepth(right)) + 1
    }

    def minDepth(node: TreeNode): Int = node match {
      case Leaf => 0
      case TreeItem(value, left, right) => math.min(minDepth(left), minDepth(right)) + 1
    }

    maxDepth(node) - minDepth(node) < 2
  }

  def balance(node: TreeNode): TreeNode = {
    val array = node.inOrder
    TreeHelper.generateTree(array)
  }

}

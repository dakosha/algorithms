package kz.algorithms.tree

import kz.algorithms.base.Node

trait TreeNode {
  def left: TreeNode
  def right: TreeNode
  def parent: TreeNode
  def value: Int
  def insert(VAL: Int): TreeNode
  def delete(VAL: Int): TreeNode
  def find(VAL: Int): TreeNode
  def inOrder: Array[Int]
  def preOrder: Array[Int]
  def postOrder: Array[Int]
}

object Leaf extends TreeNode {
  override def left = ???
  override def right = ???
  override def parent = ???
  override def value = -1
  override def toString = "Leaf"
  override def insert(VAL: Int) = ???
  override def delete(VAL: Int) = ???
  override def find(VAL: Int) = ???
  override def inOrder: Array[Int] = Array()
  override def preOrder: Array[Int] = Array()
  override def postOrder: Array[Int] = Array()
}

case class TreeItem(val value: Int,
                    var parent: TreeNode,
                    var left: TreeNode = Leaf,
                    var right: TreeNode = Leaf) extends TreeNode {

  override def toString = s"[$left-$value-$right]"

  //override def toString = this.value.toString

  override def insert(VAL: Int) = {
    if (VAL > value) {
      right match {
        case TreeItem(n, p, r, l) => right.insert(VAL)
        case Leaf => right = TreeItem(VAL, this)
      }
    }
    else if (VAL < value) {
      left match {
        case TreeItem(n, p, r, l) => left.insert(VAL)
        case Leaf => left = TreeItem(VAL, this)
      }
    }
    this
  }

  override def find(VAL: Int): TreeNode = {
    if (VAL > value) {
      right.find(VAL)
    }
    else if (VAL < value) {
      left.find(VAL)
    }
    else if (VAL == value) {
      return this
    }
    else {
      return null
    }
  }

  override def delete(VAL: Int): TreeNode = {
    if (VAL > value) {
      right match {
        case TreeItem(n, p, l, r) => {
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
        case TreeItem(n, p, l, r) => {
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

  def isSubTree(node1: TreeNode, node2: TreeNode): Boolean = {

    val node = node1.find(node2.value)
    if (node==null) return false


    return false
  }
  
  def findCommonParent(node1: TreeNode, node2: TreeNode): TreeNode = {
    var n1 = node1
    while (n1.parent!=null) {
      var n2 = node2
      while (n2.parent!=null) {
        if (n1.parent == n2.parent)
          return n1.parent
        n2 = n2.parent
      }
      n1 = n1.parent
    }
    return null
  }

  def nextInOrderNode(node: TreeNode): TreeNode = {
    if (node.right==Leaf) {
      var n = node
      while (n.parent != null && n.parent.value < node.value)
        n = n.parent

      if (n.parent!=null) return n.parent
      else return Leaf
    }
    else {

      var n = node.right
      while (n.left!=Leaf)
        n = n.left
      return n
    }
  }

  def generateLinkedLists(treeNode: TreeNode): Array[Node[TreeNode]] = {
    val node = Node(treeNode)
    var array = Array(node)

    def iterate: Unit = {
      var levelNode: Node[TreeNode] = null
      var node = array(array.length-1)
      while (node!=null) {
        node.value match {
          case TreeItem(v, p, l, r) => {
            l match {
              case TreeItem(v1, p1, l1, r1) => {
                if (levelNode==null) levelNode = Node(l)
                else levelNode.addLast(l)
              }
              case _ => {}
            }
            r match {
              case TreeItem(v1, p1, l1, r1) => {
                if (levelNode==null) levelNode = Node(r)
                else levelNode.addLast(r)
              }
              case _ => {}
            }
          }
        }
        node = node.next
      }
      if (levelNode==null) return
      array = array ++ Array(levelNode)
      iterate
    }

    iterate
    array
  }

  def generateTree(array: Array[Int]) = {

    def generateTree(start: Int, end: Int, parent: TreeNode): TreeNode = {
      if (start == end)
        return Leaf;

      val middle = (start + end) / 2;
      val node = TreeItem(array(middle), parent)

      node.left = generateTree(start, middle, node)
      node.right = generateTree(middle+1, end, node)
      node.parent = parent

      node
    }

    generateTree(0, array.length, null)
  }

  def isBalanced(node: TreeNode): Boolean = {

    def maxDepth(node: TreeNode): Int = node match {
      case Leaf => 0
      case TreeItem(value, parent, left, right) => math.max(maxDepth(left), maxDepth(right)) + 1
    }

    def minDepth(node: TreeNode): Int = node match {
      case Leaf => 0
      case TreeItem(value, parent, left, right) => math.min(minDepth(left), minDepth(right)) + 1
    }

    maxDepth(node) - minDepth(node) < 2
  }

  def balance(node: TreeNode): TreeNode = {
    val array = node.inOrder
    TreeHelper.generateTree(array)
  }

}

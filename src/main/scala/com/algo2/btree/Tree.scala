package com.algo2.btree

/**
  * @author Dauren Mussa
  * @since 12/4/16
  */
class Tree {

  private var root: Option[TreeNode] = None

  protected case class TreeNode(val value: Int,
                                var leftNode: Option[TreeNode] = None,
                                var rightNode: Option[TreeNode] = None,
                                var parent: Option[TreeNode] = None,
                                var height: Int = 1) {
    override def toString: String = this.value.toString
  }

  def insertValue(someValue: Int): Tree = {

    def insertInternal(someValue: Int, parent: Option[TreeNode]): Option[TreeNode] = {
      parent match {
        case Some(node) if (node.value >= someValue) => {
          node.leftNode match {
            case None => {
              val currentNode = Some(TreeNode(someValue, parent = parent, height = 1))
              node.leftNode = currentNode
              currentNode
            }
            case Some(leftNode) => {
              insertInternal(someValue, node.leftNode)
            }
          }
        }
        case Some(node) if (node.value < someValue) => {
          node.rightNode match {
            case None => {
              val currentNode = Some(TreeNode(someValue, parent = parent, height = 1))
              node.rightNode = currentNode
              currentNode
            }
            case Some(rightNode) => {
              insertInternal(someValue, node.rightNode)
            }
          }
        }
      }
    }

    def insertNode(node: TreeNode): TreeNode = {
      null
    }

    def reCalculateHeights(node: Option[TreeNode]): Unit = {
      var cNode = node.get
      while (cNode.parent.isDefined && cNode.height + 1 > cNode.parent.get.height) {
        val newHeight = cNode.height + 1
        cNode = cNode.parent.get
        cNode.height = newHeight
      }
    }

    root match {
      case None => {
        root = Some(TreeNode(someValue))
        this
      }
      case Some(node) => {
        reCalculateHeights(insertInternal(someValue, root))
        this
      }
    }
  }

  def search(searchValue: Int): Option[Int] = {
    def searchInternal(searchValue: Int, parent: Option[TreeNode], level: Int): Option[Int] = {
      parent match {
        case None => None
        case Some(node) if (node.value == searchValue) => {
          println(s"level -> $level")
          Some(node.value)
        }
        case Some(node) if (node.value > searchValue) => searchInternal(searchValue, node.leftNode, level + 1)
        case Some(node) if (node.value < searchValue) => searchInternal(searchValue, node.rightNode, level + 1)
      }
    }

    root match {
      case None => {
        None
      }
      case Some(node) => {
        searchInternal(searchValue, root, 1)
      }
    }
  }

  def height: Int = {
    root match {
      case None => 0
      case Some(node) => node.height
    }
  }

  def toList: List[Int] = {

    def toListInternal(parent: Option[TreeNode], level: Int): List[Int] = {
      parent match {
        case None => {
          List.empty
        }
        case Some(node) => {
          toListInternal(node.leftNode, level + 1) ::: List(node.value) ::: toListInternal(node.rightNode, level + 1)
        }
      }
    }

    root match {
      case None => List.empty
      case Some(node) => {
        val list = toListInternal(root, 0)
        list
      }
    }
  }

  def organiseTree(list: List[Int], parent: Option[TreeNode]): Option[TreeNode] = {

    list match {
      case Nil => {
        None
      }
      case list => {
        val value = list(list.size / 2)
        val currentNode = TreeNode(value, parent = parent)
        val partition = list.partition(elem => elem < currentNode.value)

        currentNode.leftNode = organiseTree(partition._1, Some(currentNode))
        currentNode.rightNode = organiseTree(partition._2.tail, Some(currentNode))

        Some(currentNode)
      }
    }
  }

  def balanceTreeAVL: Unit = {

    def isTreeBalanced(node: TreeNode): Boolean = {
      var leftNode = node
      var rightNode = node
      var leftLevel = 0
      var rightLevel = 0
      while (leftNode.leftNode.isDefined) {
        leftNode = leftNode.leftNode.get
        leftLevel += 1
      }
      while (rightNode.rightNode.isDefined) {
        rightNode = rightNode.rightNode.get
        rightLevel += 1
      }
      Math.abs(rightLevel - leftLevel) <= 1
    }

  }

}

object Tree {
  def apply(list: List[Int]): Tree = {
    val tree = new Tree
    tree.root = tree.organiseTree(list, None)
    tree
  }
}
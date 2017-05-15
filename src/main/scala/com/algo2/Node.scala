package com.algo2

/**
  * @author Dauren Mussa
  * @since 12/3/16
  */
case class Node[T](val value: T, var next: Option[Node[T]] = None, var prev: Option[Node[T]] = None) {

  def addNext(someValue: T): Node[T] = {
    this.next match {
      case None => {
        val currentNode = Some(Node(someValue))
        this.next = currentNode
        currentNode.get.prev = Some(this)
        currentNode.get
      }
      case Some(v) => {
        v.addNext(someValue)
      }
    }
  }

  def addPrev(someValue: T): Node[T] = {
    this.prev match {
      case None => {
        val currentNode = Some(Node(someValue))
        this.prev = currentNode
        currentNode.get.next = Some(this)
        currentNode.get
      }
      case Some(v) => {
        v.addPrev(someValue)
      }
    }
  }

  def insertNext(someValue: T): Node[T] = {
    this.next match {
      case None => this.addNext(someValue)
      case Some(v) => {
        val currentNode = Node(someValue)

        currentNode.next = this.next
        currentNode.prev = Some(this)
        v.prev = Some(currentNode)
        this.next = Some(currentNode)

        currentNode
      }
    }
  }

  def insertPrev(someValue: T): Node[T] = {
    this.prev match {
      case None => this.addPrev(someValue)
      case Some(v) => {
        val currentNode = Node(someValue)

        currentNode.prev = this.prev
        currentNode.next = Some(this)
        v.next = Some(currentNode)
        this.prev = Some(currentNode)

        currentNode
      }
    }
  }

  def printPrev: String = this.prev match {
    case None => "start"
    case Some(v) => s"${this.prev.get.printPrev} -> ${v.value.toString}"
  }

  def printNext: String = this.next match {
    case None => "end"
    case Some(v) => s"${v.value.toString} -> ${this.next.get.printNext}"
  }

  def printAll: String = s"$printPrev -> ${value.toString} -> $printNext"

  override def toString: String = value.toString

}
package kz.algorithms.graph

import kz.algorithms.queue.Queue
import kz.algorithms.stack.Stack

class Graph {

  var connections = Map[String, Connection]()
  var points = Map[Int, Point]()

  def addRoute(from: Int, to: Int): Unit = {
    var f: Point = null
    var t: Point = null
    var c: Connection = null
    points.get(from) match {
      case None => {
        f = Point(from)
        points = points + (from -> f)
      }
      case Some(p) => {
        f = p
      }
    }
    points.get(to) match {
      case None => {
        t = Point(to)
        points = points + (to->t)
      }
      case Some(p) => {
        t = p
      }
    }
    val conName = f.name + "->" + t.name
    connections.get(conName) match {
      case None => {
        c = Connection(conName)
        connections = connections + (conName -> c)
      }
      case Some(p) => {
        c = p
      }
    }
    c.from = f
    c.to = t
    t.from = t.from ++ Array(c)
    f.to = f.to ++ Array(c)
  }

  def printRoutes(from: Int, to: Int) = {
    var was = Set[Int](from)
    val route = new Stack[Int]
    route.push(from)

    def find(from: Int, to: Int): Unit = {
      if (from == to) {
        println(route)
      }
      else {
        for { p <- points.get(from) } yield {
          for {
            con <- p.to
            if (!was.contains(con.to.name))
          } yield {
            route.push(con.to.name)
            was = was + con.to.name
            find(con.to.name, to)
            was = was - con.to.name
            route.pop
          }
        }
      }
    }

    find(from, to)
  }

  def findRoutesWidely(from: Int, to: Int) = {
    val queue = new Queue[Stack[Int]]
    val stack = new Stack[Int]
    stack.push(from)
    queue.enQueue(stack)

    def iteration(queue: Queue[Stack[Int]]): Unit = {

      val st = queue.deQueue
      val point = points.get(st.peek.get)
      if (point.get.name == to) {
        println(st)
      }

      for {
        con <- point.get.to
        stNew = copyStack(st, con.to.name)
        if (stNew!=null)
      } yield {
        queue.enQueue(stNew)
      }

      if (!queue.empty)
        iteration(queue)

    }

    def copyStack[T](s: Stack[T], step: T): Stack[T] = {
      val res = new Stack[T]
      val temp = new Stack[T]
      var flag = false
      while (!s.empty) {
        val t = s.pop
        if (t==step)
          flag = true
        temp.push(t)
      }
      while (!temp.empty) {
        val t = temp.pop
        res.push(t)
        s.push(t)
      }
      res.push(step)
      if (flag) return null
      res
    }

    iteration(queue)
  }

  override def toString = {
    for {
      key <- points.keys
      point <- points.get(key)
    } yield {
      println(point.name)
      for {
        con <- point.to
      } yield {
        println(con)
      }
    }
    ""
  }

}

case class Point(name: Int) {
  var from = Array[Connection]()
  var to = Array[Connection]()

  override def toString = {
    this.name.toString
  }
}

case class Connection(name: String) {
  var from: Point = null
  var to: Point = null

  override def toString = {
    from.toString + "->" + to.toString
  }

}
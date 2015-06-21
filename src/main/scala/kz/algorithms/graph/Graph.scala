package kz.algorithms.graph

import kz.algorithms.queue.Queue
import kz.algorithms.stack.Stack

/**
 * Created by Alina on 20.06.15.
 */
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

    def iteration(queue: Queue[Stack[Int]]): Unit = {
      val step = queue.deQueue
      val point = step.peek.get
      val p = points.get(point).getOrElse(null)
      for { con <- p.to } yield {
        val to = con.to
        val nStack = new Stack[Int]
      }
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
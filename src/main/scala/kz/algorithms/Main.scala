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

    val graph = new Graph

    graph.addRoute(1,2)
    graph.addRoute(1,3)
    graph.addRoute(2,4)
    graph.addRoute(2,5)
    graph.addRoute(4,1)
    graph.addRoute(4,5)

    println("wide search")
    graph.findRoutesWidely(1,5)

    println("deep search")
    graph.printRoutes(1,5)
  }


}

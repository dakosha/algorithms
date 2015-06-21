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
    graph.addRoute(1,4)
    graph.addRoute(2,5)
    graph.addRoute(2,6)
    graph.addRoute(3,7)
    graph.addRoute(3,8)
    graph.addRoute(4,9)
    graph.addRoute(4,10)
    graph.addRoute(5,11)
    graph.addRoute(5,12)
    graph.addRoute(6,1)
    graph.addRoute(6,10)
    graph.addRoute(10,6)
    graph.addRoute(10,12)
    graph.addRoute(6,12)

    graph.printRoutes(1,12)

  }


}

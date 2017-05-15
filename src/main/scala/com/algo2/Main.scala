package com.algo2

/**
  * @author Dauren Mussa
  * @since 12/3/16
  */
object Main {

  def main(args: Array[String]): Unit = {

    var a = 5
    var b = 1
    def c = a + b
    def r = c * c
    def a1 = r - a

    println(a1)

    a = 1

    println(a1)

    b = 2

    println(a1)



  }

}

trait Expression {
  def eval: Expression
}


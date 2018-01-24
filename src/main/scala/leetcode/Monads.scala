package leetcode

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.util.Random

/**
  * @author Dauren Mussa
  * @since 12/10/17
  */
object Monads {

  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 5, 6, 7)

    def wrap(index: Int): Future[Int] = {
      Future {
        val atr = Random.nextInt(1000 * index)
        println(Thread.currentThread().getName + " " + atr)
        Thread.sleep(atr)
        if (atr % 2==0) {
          throw new RuntimeException("Is not even!")
        }
        atr
      }
    }

    val results = for {
      index <- list
    } yield wrap(index)

    Thread.sleep(1500)

    println(results)

    val furutes =Future.sequence(results)

    println(furutes)

    def sum3(value: Int) = 3 + value

    def sum5(value: Int) = 5 + value

    val init = Some(10)

    val sum8 = sum3 _ compose sum5 _

    val init3 = init.map(sum8)

    println(init3)

    val part1: PartialFunction[Int, String] = {
      case 1 => "one"
      case 2 => "two"
    }

    val part2: PartialFunction[Int, String] = {
      case 3 => "three"
      case 4 => "four"
    }

    val partAll = part1 orElse part2

    println(partAll(4))

    val list1 = List(1, 2, 3, 4) map {
      (_: Int) + (_: Int)
    }.curried
    println(list1.map(_ {
      3
    }))

  }

}

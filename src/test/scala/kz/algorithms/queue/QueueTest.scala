package kz.algorithms.queue

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * Created by Alina on 20.06.15.
 */
@RunWith(classOf[JUnitRunner])
class QueueTest extends FunSuite {

  test("Empty queue should throw an exception") {
    val queue = new Queue
    intercept[NoSuchElementException] {
      queue.deQueue
    }
  }

  test("Empty queue should return same element just after pushing") {
    val queue = new Queue[Int]
    val value = 10
    queue.enQueue(value)
    val newVal = queue.deQueue
    assert(newVal == value)
  }

  test("Queue should be empty") {
    val queue = new Queue[Int]
    queue.enQueue(1)
    queue.enQueue(2)
    queue.deQueue
    queue.deQueue
    assert(queue.empty)
  }

  test("Queue should return elements in the same order") {
    val queue = new Queue[Int]
    queue.enQueue(1)
    queue.enQueue(2)
    queue.enQueue(3)
    assert(queue.deQueue == 1)
    assert(queue.deQueue == 2)
    assert(queue.deQueue == 3)
  }
}

package kz.algorithms.stack

import java.util.NoSuchElementException

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * Created by Alina on 20.06.15.
 */
@RunWith(classOf[JUnitRunner])
class StackTest extends FunSuite {

  test("Empty stack should throw an Exception") {
    val stack = new Stack
    intercept[NoSuchElementException] {
      stack.pop
    }
  }

  test("Stack should return last pushed element") {
    val stack = new Stack[Int]
    val value = 5
    stack.push(value)
    val newVal = stack.pop
    assert(value == newVal)
  }

  test("Stack should be empty") {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.pop
    stack.pop
    assert(stack.empty)
  }

  test("Stack should return elements in backward order") {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.push(3)
    assert(stack.pop == 3)
    assert(stack.pop == 2)
    assert(stack.pop == 1)
  }

}
package com.algo2

/**
  * @author Dauren Mussa
  * @since 12/4/16
  */
object Sorting {


  //Bubble sort
  def bubbleSort(array: Array[Int]): Array[Int] = {
    for {
      i <- 0 to array.length - 2
      j <- i + 1 to array.length - 1
    } yield {
      if (array(i) > array(j)) {
        val temp = array(i)
        array(i) = array(j)
        array(j) = temp
      }
    }
    array
  }

  //Insertion sort
  def insertionSort(array: Array[Int]): Array[Int] = {
    val list = array.toList

    def findToInsert(elem: Int, result: List[Int]): List[Int] = {
      def insert(result: List[Int]): List[Int] = result match {
        case Nil => List(elem)
        case x :: xs if (elem < x) => elem :: x :: xs
        case x :: xs => x :: insert(xs)
      }
      insert(result)
    }

    def sorting(original: List[Int], result: List[Int]): List[Int] = original match {
      case Nil => result
      case elem :: tail => sorting(tail, findToInsert(elem, result))
    }

    sorting(list, List()).toArray
  }

  def quickSort(array: Array[Int]): Array[Int] = {
    if (array.length <= 1) array
    else {
      Array.concat(
        quickSort(array.filter(array(array.length / 2) >)),
        array.filter(array(array.length / 2) ==),
        quickSort(array.filter(array(array.length / 2) <)))
    }
  }

  def quickSortDefault(xs: Array[Int]) {
    def swap(i: Int, j: Int) {
      val t = xs(i);
      xs(i) = xs(j);
      xs(j) = t
    }
    def sort1(l: Int, r: Int) {
      val pivot = xs((l + r) / 2)
      var i = l
      var j = r
      while (i <= j) {
        while (xs(i) < pivot) i += 1
        while (xs(j) > pivot) j -= 1
        if (i <= j) {
          swap(i, j)
          i += 1
          j -= 1
        }
      }
      if (l < j) sort1(l, j)
      if (j < r) sort1(i, r)
    }

    sort1(0, xs.length - 1)
  }

}

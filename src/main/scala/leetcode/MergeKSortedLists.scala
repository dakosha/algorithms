package leetcode

/**
  * @author Dauren Mussa
  * @since 11/13/17
  */

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object MergeKSortedLists {
  def main(args: Array[String]): Unit = {
    var resultList = mergeKLists(Array())
    while (resultList!=null) {
      print(resultList.x + "->")
      resultList = resultList.next
    }
    println()
  }

  def mergeKLists(lists: Array[ListNode]): ListNode = {

    def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
      if (list1==null) {
        return list2
      } else if (list2==null) {
        return list1
      } else {
        if (list1.x < list2.x) {
          list1.next = mergeTwoLists(list1.next, list2)
          return list1
        } else {
          list2.next = mergeTwoLists(list1, list2.next)
          return list2
        }
      }
    }

    var ll = lists
    if (ll.isEmpty) return null
    var resultList = ll.head
    ll = ll.drop(1)
    while (ll.nonEmpty) {
      resultList = mergeTwoLists(resultList, ll.head)
      ll = ll.drop(1)
    }
    return resultList
  }

}

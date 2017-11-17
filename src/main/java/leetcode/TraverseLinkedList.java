package leetcode;

import sun.util.resources.cldr.ebu.CurrencyNames_ebu;

/**
 * @author Dauren Mussa
 * @since 11/14/17
 */
public class TraverseLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        TraverseLinkedList traverseLinkedList = new TraverseLinkedList();

        traverseLinkedList.printList(node);

        node = traverseLinkedList.reverseKGroup(node, 5);

        traverseLinkedList.printList(node);
    }

    public ListNode reverseKNodes(ListNode head, int k) {
        ListNode current = head;
        ListNode newHead = head;
        ListNode prevHead = head;
        while (current != null) {
            if (current.next !=null) {
                newHead = current.next;
                current.next = current.next.next;
                newHead.next = prevHead;
                prevHead = newHead;
            } else {
                break;
            }
        }

        return prevHead;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        ListNode newHead = head;
        ListNode prevHead = head;
        while (current != null) {
            if (current.next !=null) {
                newHead = current.next;
                current.next = current.next.next;
                newHead.next = prevHead;
                prevHead = newHead;
            } else {
                break;
            }
        }

        return prevHead;
    }

    private void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}

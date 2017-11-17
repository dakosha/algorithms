package leetcode;

/**
 * @author Dauren Mussa
 * @since 11/10/17
 */

import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 */

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode a = new ListNode(7);
        a.next = new ListNode(2);
        a.next.next = new ListNode(4);
        a.next.next.next = new ListNode(3);

        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        ListNode c = addTwoNumbers.addTwoNumbersTravers(a, b);
        addTwoNumbers.print(a);
        addTwoNumbers.print(b);
        addTwoNumbers.print(c);
    }

    private void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        int sum = 0;
        LinkedList<ListNode> list = new LinkedList<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            list.add(new ListNode(sum % 10));
            int val = sum / 10;
            if (val > 0) {
                sum = val;
            } else {
                sum = 0;
            }
        }

        if (sum > 0) {
            list.add(new ListNode(sum));
        }

        if (list.size() > 0) {
            ListNode node = new ListNode(list.pollFirst().val);
            result = node;
            while (list.size() > 0) {
                node.next = new ListNode(list.pollFirst().val);
                node = node.next;
            }
        }
        return result;
    }

    private ListNode recursiveSum(ListNode a, ListNode b, int sum) {
        return new ListNode(a.val + b.val);
    }

    public ListNode addTwoNumbersTravers(ListNode l1, ListNode l2) {
        int length1 = 0;
        int length2 = 0;
        ListNode a = l1;
        ListNode b = l2;
        while (a != null) {
            length1++;
            a = a.next;
        }
        while (b != null) {
            length2++;
            b = b.next;
        }
        int zeroAmount = Math.abs(length1 - length2);
        if (zeroAmount > 0) {
            ListNode c = new ListNode(0);
            ListNode zeroNodes = c;
            ListNode lastZero = c;
            zeroAmount--;
            while (zeroAmount > 0) {
                c.next = new ListNode(0);
                lastZero = c;
                c = c.next;
                zeroAmount--;
            }

            if (length1 > length2) {
                c.next = l2;
                l2 = zeroNodes;
            } else {
                c.next = l1;
                l1 = zeroNodes;
            }
        }

        this.print(l1);
        this.print(l2);

        return null;
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

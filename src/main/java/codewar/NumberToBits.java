package codewar;

/**
 * @author Dauren Mussa
 * @since 5/22/17
 */
public class NumberToBits {

    public static void main(String[] args) {
        ListNode nullList = null;
        ListNode three = new ListNode(1);
        three.next = new ListNode(2);
        three.next.next = new ListNode(2);


    }

    public ListNode deleteDuplicates(ListNode a) {
        ListNode result;
        ListNode current;
        ListNode head;
        if (a != null) {
            result = new ListNode(a.val);
            current = a.next;
            head = result;
        }
        else {
            return null;
        }

        while (current != null) {
            if (current.val != result.val) {
                result.next = new ListNode(current.val);
                result = result.next;
            }
            current = current.next;
        }

        return head;
    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

}

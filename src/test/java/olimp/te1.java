package olimp;

public class te1 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode origin = new ListNode(-1);
        ListNode head = origin;

        while(l1 != null && l2 != null){
            if (l1.val > l2.val){
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }else{
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            head = head.next;
        }

        if (l1 != null) head.next = l1;
        if (l2 != null) head.next = l2;

        return origin.next;
    }
}

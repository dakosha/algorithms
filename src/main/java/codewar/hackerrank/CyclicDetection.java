package codewar.hackerrank;

/**
 * @author Dauren Mussa
 * @since 5/21/17
 */
public class CyclicDetection {

    public static void main(String[] args) {
        Node head = new Node();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();

        head.next = n1;
        n1.next=n2;
        n2.next = n3;
        n3.next = head;
        n4.next = null;

        System.out.println(hasCycle(head));
    }

    static class Node {
        int data;
        Node next;
    }

    static boolean hasCycle(Node head) {
        Node tNode = new Node();
        tNode.data = 0;
        tNode.next = null;

        Node current = head;
        while (current != null) {
            if (current.next == tNode) {
                return true;
            }
            Node t = current.next;
            current.next = tNode;
            current = t;
        }

        return false;
    }

}

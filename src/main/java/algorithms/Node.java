package algorithms;

public class Node {
    public Node next;
    public String value;

    public Node(String value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Node root = new Node("A");
        root.next = new Node("B");
        root.next.next = new Node("C");
        root.next.next.next = new Node("D");
        root.next.next.next.next = root.next;
    }

    public static class Tree {
        Tree left;
        Tree right;
        String value;
    }

}



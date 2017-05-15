package codewar.hackerrank;

/**
 * @author Dauren Mussa
 * @since 4/30/17
 */

public class MergeNodes {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Node node = new Node(1);
        node.next = new Node(3);
        node.next.next = new Node(5);
        node.next.next.next = new Node(6);

        Node node1 = new Node(2);
        node1.next = new Node(4);
        node1.next.next = new Node(7);

        System.out.println(node);
        System.out.println(node1);

        MergeNodes mergeNodes = new MergeNodes();
        Node merged = mergeNodes.MergeLists(node, node1);

        System.out.println(merged);

    }

    Node MergeLists(Node root1, Node root2) {
        if (root1 == null)
            return root2 == null ? null : root2;
        if (root2 == null)
            return root1;

        Node returnNode, n1;
        returnNode = n1 = root1.data < root2.data ? root1 : root2;
        Node n2 = root1.data < root2.data ? root2 : root1;

        while (n1 != null && n2 != null) {
            while (n1.next != null && n1.next.data <= n2.data)
                n1 = n1.next;
            Node oldChild = n1.next;
            n1.next = n2;
            n1 = n2;
            n2 = oldChild;
        }
        return returnNode;
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            Node current = this;
            while (current != null) {
                stringBuilder.append(current.data);
                stringBuilder.append(" -> ");
                current = current.next;
            }
            stringBuilder.append("NULL");
            return stringBuilder.toString();
        }
    }

}

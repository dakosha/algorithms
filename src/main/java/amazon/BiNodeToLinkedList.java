package amazon;

/**
 * @author Dauren Mussa
 * @since 1/31/18
 */
public class BiNodeToLinkedList {

    public static void main(String[] args) {
        BiNode root = new BiNode(8);

        root.node1 = new BiNode(4);
        root.node2 = new BiNode(12);

        root.node1.node1 = new BiNode(2);
        root.node1.node2 = new BiNode(6);

        root.node2.node1 = new BiNode(10);
        root.node2.node2 = new BiNode(14);

        root.node1.node1.node1 = new BiNode(1);
        root.node1.node1.node2 = new BiNode(3);
        root.node1.node2.node1 = new BiNode(5);
        root.node1.node2.node2 = new BiNode(7);

        root.node2.node1.node1 = new BiNode(9);
        root.node2.node1.node2 = new BiNode(11);
        root.node2.node2.node1 = new BiNode(13);
        root.node2.node2.node2 = new BiNode(15);

        BiNode result = mapToLinked(root);
        BiNode end = null;

        while (result != null) {
            System.out.print(result.data + " ");
            if (result.node2 == null) {
                end = result;
            }
            result = result.node2;
        }
        System.out.println();

        while (end!=null) {
            System.out.print(end.data+" ");
            end = end.node1;
        }
    }

    public static BiNode mapToLinked(BiNode root) {
        if (root.node1 == null && root.node2 == null) {
            return root;
        } else {
            BiNode result = null;
            if (root.node1 != null) {
                result = mapToLinked(root.node1);
            }
            if (result != null) {
                BiNode temp = result;
                while (temp.node2 != null) {
                    temp.node2.node1 = temp;
                    temp = temp.node2;
                }
                temp.node2 = root;
                root.node1 = temp;
                if (root.node2 != null) {
                    temp.node2.node2 = mapToLinked(root.node2);
                    temp.node2.node2.node1 = temp.node2;
                }
            } else {
                result = root;
                if (root.node2 != null) {
                    result.node2 = mapToLinked(root.node2);
                    result.node2.node1 = result;
                }
            }
            return result;
        }
    }

    public static class BiNode {
        public BiNode node1, node2;
        public int data;

        public BiNode(int data) {
            this.data = data;
        }
    }

}

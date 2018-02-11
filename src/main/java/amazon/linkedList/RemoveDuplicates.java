package amazon.linkedList;

import java.util.HashSet;

/**
 * @author Dauren Mussa
 * @since 2/1/18
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        LinkedNode root = LinkedNode.generate();
        printNode(root);

        LinkedNode kth = getKthElemFromLast(root, 2, 0);
        printNode(kth);

        root = removeDuplicates2(root);
        printNode(root);
    }

    public static void printNode(LinkedNode root) {
        LinkedNode temp = root;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static LinkedNode getKthElemFromLast(LinkedNode root, int k, int step) {
        if (root != null) {
            LinkedNode result = getKthElemFromLast(root.next, k, step + 1);
            if (result != null) {
                return result;
            } else {
                if (step == k) {
                    return root;
                }
            }
        }
        return null;
    }

    //O(N^2) S(1)
    public static LinkedNode removeDuplicates2(LinkedNode root) {
        LinkedNode temp = root;
        while (root != null) {
            LinkedNode checker = root.next;
            LinkedNode prev = root;

            while (checker != null) {
                if (checker.data == root.data) {
                    prev.next = checker.next;
                }
                prev = checker;
                checker = checker.next;
            }
            root = root.next;
        }
        return temp;
    }

    //O(N) and S(N)
    public static LinkedNode removeDuplicates1(LinkedNode root) {
        LinkedNode temp = root;
        HashSet<Integer> set = new HashSet<>();

        LinkedNode prev = null;
        while (root != null) {
            if (set.contains(root.data)) {
                prev.next = root.next;
            } else {
                prev = root;
                set.add(prev.data);
            }
            root = root.next;
        }

        return temp;
    }


}

package leetcode;

/**
 * @author Dauren Mussa
 * @since 11/22/17
 */
public class ImportantReversePairs {

    public static void main(String[] args) {

        BST bst = new BST(false);

        for (int i=0; i<50000; i++) {
            bst.put(i);
        }

        System.out.println(bst);

    }

    public int reversePairs(int[] nums) {
        int result = 0;
        boolean[] flags = new boolean[nums.length];

        for (int i = nums.length - 1; i > 0; i--) {

            if (!flags[i]) {

                long val = (long) nums[i] * (long) 2;
                flags[i] = true;

                int subResult = 0;
                int multiplier = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (val < nums[j]) {
                        subResult += multiplier;
                    }
                    if (nums[i] == nums[j]) {
                        flags[j] = true;
                        multiplier++;
                    }
                }
                result += subResult;
            }
        }

        return result;
    }

    public static class BST {

        Node root = null;
        private boolean isRecursive = false;

        public BST(boolean isRecursive) {
            this.isRecursive = isRecursive;
        }

        public void put(int value) {
            if (root == null) {
                root = new Node(value);
            } else {
                if (isRecursive) {
                    putRecursive(root, value);
                } else {
                    putLoop(root, value);
                }
            }
        }

        private void putLoop(Node node, int value) {
            Node current = node;
            while (true) {
                if (current.value == value) {
                    current.count++;
                    break;
                } else if (current.value > value) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new Node(value);
                        break;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = new Node(value);
                        break;
                    }
                }
            }
        }

        private void putRecursive(Node node, int value) {
            if (node.value > value) {
                if (node.left == null) {
                    node.left = new Node(value);
                } else {
                    putRecursive(node.left, value);
                }
            } else if (node.value < value) {
                if (node.right == null) {
                    node.right = new Node(value);
                } else {
                    putRecursive(node.right, value);
                }
            } else {
                node.count++;
            }
        }

        public Node find(int value) {
            if (root != null) {
                return findRecursive(root, value);
            } else {
                return null;
            }
        }

        private Node findLoop(Node node, int value) {
            Node current = node;
            while (true) {

            }
        }

        private Node findRecursive(Node node, int value) {
            if (node.value == value) {
                return node;
            } else if (node.value > value) {
                return findRecursive(node.left, value);
            } else {
                return findRecursive(node.right, value);
            }
        }

        public Node delete(int value) {
            if (root != null) {
                return deleteRecursive(root, value);
            } else {
                return null;
            }
        }

        private Node deleteRecursive(Node node, int value) {
            if (node.value == value) {
                if (node.count > 1) {
                    node.count--;
                    return node;
                } else {
                    return null;
                }
            } else if (node.value > value) {
                return deleteRecursive(node.left, value);
            } else {
                return deleteRecursive(node.right, value);
            }
        }

    }

    public static class Node {
        int value;
        int count;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.count = 1;
        }
    }

}

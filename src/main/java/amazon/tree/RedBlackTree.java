package amazon.tree;

/**
 * @author Dauren Mussa
 * @since 2/12/18
 */
public class RedBlackTree {

    private TreeNode root = null;

    private static TreeNode parent(TreeNode node) {
        if (node != null) {
            return node.parent;
        }
        return null;
    }

    private static TreeNode sibling(TreeNode node) {
        TreeNode parent = parent(node);
        if (parent != null) {
            if (parent.left == node) {
                return parent.right;
            } else {
                return parent.left;
            }
        }
        return null;
    }

    private static TreeNode uncle(TreeNode node) {
        TreeNode parent = parent(node);
        if (parent != null) {
            return sibling(parent);
        }
        return null;
    }

    private static TreeNode grandParent(TreeNode node) {
        return parent(parent(node));
    }

    private static void rotateLeft(TreeNode node) {
        TreeNode grandParent = grandParent(node);
        TreeNode parent = parent(node);
        if (grandParent != null && parent != null) {

            //Changing children
            grandParent.right = parent.left;
            parent.left = grandParent;

            //Changing parents
            parent.parent = grandParent.parent;
            grandParent.parent = parent;

            //Changing right parent.
            if (grandParent.right != null) {
                grandParent.right.parent = grandParent;
            }
        }
    }

    private static void rotateRight(TreeNode node) {
        TreeNode grandParent = grandParent(node);
        TreeNode parent = parent(node);

        if (grandParent != null && parent != null) {

            //Changing children
            grandParent.left = parent.right;
            parent.right = grandParent;

            //Changing parents
            parent.parent = grandParent.parent;
            grandParent.parent = parent;

            //Changing left parent.
            if (grandParent.left != null) {
                grandParent.left.parent = grandParent;
            }
        }
    }

    private static TreeNode findNode(TreeNode parent, Integer value) {
        TreeNode temp = parent;
        TreeNode rTemp;
        do {
            rTemp = temp;
            if (value > temp.value) {
                temp = temp.right;
            } else if (value < temp.value) {
                temp = temp.left;
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    private static TreeNode insertNode(TreeNode parent, Integer value) {
        TreeNode temp = parent;
        TreeNode pTemp;

        do {
            pTemp = temp;
            if (value > temp.value) {
                temp = temp.right;
            } else if (value < temp.value) {
                temp = temp.left;
            } else {
                return temp;
            }
        } while (temp != null);

        TreeNode newNode = new TreeNode(value);
        newNode.parent = pTemp;

        if (value > pTemp.value) {
            pTemp.right = newNode;
        } else {
            pTemp.left = newNode;
        }

        return newNode;
    }

    private static void fixCase1(TreeNode node) {
        if (parent(node) == null) {
            node.color = true;
        }
    }

    private static void fixCase3(TreeNode node) {
        TreeNode parent = parent(node);
        TreeNode uncle = uncle(node);
        if (parent != null && uncle != null) {
            parent.color = true;
            uncle.color = true;
            grandParent(node).color = false;
            fixAfterInsert(grandParent(node));
        }
    }

    private static void fixCase4_1(TreeNode node) {
        TreeNode parent = parent(node);
        TreeNode grandParent = grandParent(node);

        if (parent != null && grandParent != null) {

            if (grandParent.left != null && node == grandParent.left.right) {
                rotateLeft(parent);
                node = node.left;
            } else if (grandParent.right != null && node == grandParent.right.left) {
                rotateRight(parent);
                node = node.right;
            }

            fixCase4_2(node);
        }
    }

    private static void fixCase4_2(TreeNode node) {
        TreeNode parent = parent(node);
        TreeNode grandParent = grandParent(node);

        if (parent != null && grandParent != null) {
            if (node == parent.left)
                rotateRight(grandParent);
            else
                rotateLeft(grandParent);
            parent.color = true;
            grandParent.color = false;
        }
    }

    private static void fixAfterInsert(TreeNode node) {
        if (parent(node) == null) {
            fixCase1(node);
        } else if (parent(node).color) {

        } else if (uncle(node) != null && !uncle(node).color) {
            fixCase3(node);
        } else {
            fixCase4_1(node);
        }
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        tree.insert(10);
        tree.insert(11);
        tree.insert(12);
        tree.insert(13);
        tree.insert(14);
        tree.insert(15);

        System.out.println(tree.findNode(10));
    }

    public TreeNode findNode(Integer value) {
        return findNode(root, value);
    }

    public void insert(Integer value) {
        if (root == null) {
            root = new TreeNode(value);
            fixAfterInsert(root);
        } else {
            TreeNode insertedNode = insertNode(root, value);
            fixAfterInsert(insertedNode);

            root = insertedNode;
            while (parent(root)!=null) {
                root = root.parent;
            }
        }
    }

}

package amazon.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Dauren Mussa
 * @since 2/3/18
 */
public class TreeOperations {

    private static Stack<Integer> stack = new Stack<>();
    private static int size = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);

        root.left = new TreeNode(20);

        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(25);

        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(15);

        root.right = new TreeNode(60);
        root.right.right = new TreeNode(70);
        root.right.right.right = new TreeNode(80);
        root.right.right.left = new TreeNode(65);

        List<Integer> list = treeToArray(root);
        System.out.println(list.size());

        size = list.size();

        buildArray(root);

    }

    public static List<Integer> treeToArray(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root != null) {
            result.add(root.value);
            result.addAll(treeToArray(root.left));
            result.addAll(treeToArray(root.right));
        }
        return result;
    }

    public static void buildArray(TreeNode root) {
        if (root != null) {
            stack.push(root.value);

            if (stack.size() == size) {
                System.out.println(stack);
            }

            buildArray(root.left);
            buildArray(root.right);
            if (root.left != null) {
                stack.pop();
            }
            if (root.right != null) {
                stack.pop();
            }

            buildArray(root.right);
            buildArray(root.left);
            if (root.left != null) {
                stack.pop();
            }
            if (root.right != null) {
                stack.pop();
            }
        }
    }

}

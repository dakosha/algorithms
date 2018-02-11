package amazon.tree;

/**
 * @author Dauren Mussa
 * @since 2/3/18
 */
public class TreeNode {

    public TreeNode left, right;
    public int value;

    public TreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TreeNode{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}

package amazon.tree;

/**
 * @author Dauren Mussa
 * @since 2/3/18
 */
public class TreeNode {

    public TreeNode left, right, parent;
    public int value;

    //false - red, true - black
    public boolean color = false;

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

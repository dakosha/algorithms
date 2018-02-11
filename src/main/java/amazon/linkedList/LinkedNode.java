package amazon.linkedList;

/**
 * @author Dauren Mussa
 * @since 2/1/18
 */
public class LinkedNode {

    public int data;
    public LinkedNode next;

    public LinkedNode(int value) {
        this.data = value;
    }
    public LinkedNode(int value, LinkedNode next) {
        this.data = value;
        this.next = next;
    }

    public static LinkedNode generate() {
        LinkedNode result = new LinkedNode(1, new LinkedNode(2, new LinkedNode(3, new LinkedNode(2, new LinkedNode(1, new LinkedNode(3))))));
        return result;
    }

}

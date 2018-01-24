package leetcode;

/**
 * @author Dauren Mussa
 * @since 12/2/17
 */


/*
I need to finish this task.
 */
public class LFUCache {


    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);

        cache.put(2,2);
        cache.put(1,1);
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        cache.put(3,3);
        cache.put(4,4);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        System.out.println(cache.get(4));


        //[[3],[2,2],[1,1],[2],[1],[2],[3,3],[4,4],[3],[2],[1],[4]]

    }

    java.util.Map<Integer, Node> nodeCache;
    private Node head;
    private Node last;
    private int size;
    private int capacity;

    public LFUCache(int capacity) {
        nodeCache = new java.util.HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node result = nodeCache.get(key);
        if (result == null) {
            return -1;
        } else {
            if (result != head && result != last) {
                Node cur = result;
                Node prev = cur.prev;
                Node next = cur.next;
                Node curHead = head;

                //Breaking chain
                prev.next = next;
                next.prev = prev;

                //Changing head
                cur.next = head;
                cur.prev = null;
                curHead.prev = cur;
                head = cur;

            } else if (result == last && size > 1) {
                Node cur = result;
                Node prev = cur.prev;
                Node curHead = head;

                prev.next = null;
                this.last = prev;

                curHead.prev = cur;
                cur.next = head;
                cur.prev = null;
                head = cur;
            }
            return result.value;
        }
    }

    public void put(int key, int value) {
        Node result = nodeCache.get(key);

        if (result == null) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            if (last!=null){
                last.next=newNode;
                newNode.prev=last;
                last=newNode;
            } else {
                last=newNode;
            }

            nodeCache.put(key, newNode);

            if (size == 0) {
                head = newNode;
                last = head;
            }

            size++;
        } else {
            result.value = value;
            this.get(key);
        }

        if (size > capacity) {
            nodeCache.remove(last.key);
            Node newLast = last.prev;
            if (newLast != null) {
                newLast.next = null;
            }
            last = newLast;
            size--;
        }

    }

    public static class Node {
        public int key;
        public int value;
        public Node next;
        public Node prev;

        @Override
        public String toString() {
            StringBuilder st = new StringBuilder();

            LFUCache.Node cur = this;
            while (cur != null) {
                st.append(cur.value + ":");
                cur = cur.next;
            }

            cur = this;
            while (cur != null) {
                st.append("<-" + cur.value);
                cur = cur.prev;
            }

            return st.toString();
        }
    }

}

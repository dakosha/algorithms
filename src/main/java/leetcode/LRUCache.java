package leetcode;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author Dauren Mussa
 * @since 11/22/17
 */
public class LRUCache {

    Map<Integer, Node> nodeCache;
    private Node head;
    private Node last;
    private int size;
    private int capacity;
    public LRUCache(int capacity) {
        nodeCache = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        cache.get(1);
        cache.get(2);


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
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            newNode.prev = null;
            head = newNode;
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
            newLast.next = null;
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

            Node cur = this;
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
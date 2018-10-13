/**
 * Class for deque.
 */
class Deque {
    /**
     * Variable head of node type.
     */
    private Node head;
    /**
     * Variable tail of node type.
     */
    private Node tail;
    /**
     * Variable size of int type.
     */
    private int size;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * Variable item of type integer.
         */
        private int item;
        /**
         * Variable next of type node.
         */
        private Node next;
    }
    /**
     * Constructs the object.
     */
    Deque() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    /**
     * Determines if empty.
     *
     * @return returns true if empty, False otherwise.
     */
    public boolean isEmpty() {
        return (size == 0);
    }
    /**
     * Gets the size.
     *
     * @return returns the size.
     */
    public int getSize() {
        return size;
    }
    /**
     * Method to push from front.
     *
     * @param      item1  The item1
     */
    public void pushLeft(final int item1) {
        if (head == null) {
            head = new Node();
            head.item = item1;
            head.next = null;
            tail = head;
        } else {
            Node oldhead = head;
            head = new Node();
            head.item = item1;
            head.next = oldhead;
        }
        size++;
    }
    /**
     * Method to push from back.
     *
     * @param      item2  The item 1
     */
    public void pushRight(final int item2) {
        if (tail == null) {
            tail = new Node();
            tail.item = item2;
            tail.next = null;
        } else {
            Node oldtail = tail;
            tail = new Node();
            tail.item = item2;
            tail.next = null;
            oldtail.next = tail;
        }
        size++;
    }
    /**
     * Method to pop from front.
     */
    public void popLeft() {
        if (head != null) {
            head = head.next;
            size--;
        }
    }
    /**
     * Method to pop from back.
     */
    public void popRight() {
        if (tail != null) {
            Node old = head;
            while (old.next.next != null) {
                old = old.next;
            }
            old.next = null;
            tail = old;
            size--;
        }
    }
    /**
     * Returns a string representation of the object.
     *
     * @return String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String s = "[";
            Node old1 = head;
            while (old1 != null) {
                s += old1.item + ", ";
                old1 = old1.next;
            }
            return s.substring(0, s.length() - 2) + "]";
        }
    }
}

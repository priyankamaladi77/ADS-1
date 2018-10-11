/**
 * constructs class for Linkedlist.
 */
class Linkedlist {
    /**
     * variable head of type Node.
     */
    private Node head;
    /**
     * variable size of type int.
     */
    private int size;
    /**
     * Constructs the object for Linkedlist.
     */
    Linkedlist() {
        this.head = null;
        this.size = 0;
    }
    /**
     * size of list.
     * Time complexity is constant.
     * @return returns size.
     */
    public int size() {
        return size;
    }
    /**
     * Determines if empty.
     * Time complexity is constant.
     * @return     returns true if empty, False otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }
    /**
     * inserts the value at the given position.
     * Time complexity is O(N).
     * @param      position  The position
     * @param      val     The value 1
     */
    public void insertAt(final int position, final int val) {
        insertAt(head, position, val);
    }
    /**
     inserts the value at the given position.
     * Time complexity is O(N).
     *
     * @param      node      The node
     * @param      position  The position
     * @param      val       The value
     */
    private void insertAt(final Node node,
                          final int position, final int val) {
        if (position == 0 && head == null) {
            head = new Node(val);
        } else if (position == 0 && head != null) {
            Node oldhead = head;
            head = new Node(val);
            head.setNextlink(oldhead);
        } else {
            Node temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.getNextlink();
            }
            Node nextNode = temp.getNextlink();
            Node node1 = new Node(val);
            temp.setNextlink(node1);
            node1.setNextlink(nextNode);
        }
        size++;
    }
    /**
     * reverses the head.
     * Time complexity is constant.
     */
    public void reverse() {
        head = reverse(head);
    }
    /**
     *reverse of list.
     *
     * @param      h1  The head
     *
     * @return  returns the node.
     */
    private Node reverse(final Node h1) {
        if (h1 == null || h1.getNextlink() == null) {
            return h1;
        }
        Node temp = reverse(h1.getNextlink());
        h1.getNextlink().setNextlink(h1);
        h1.setNextlink(null);
        return temp;
    }
    /**
     * Returns a string representation of the object.
     * Time complexity is O(N).
     * @return     returns String representation of the object.
     */
    public String toString() {
        String str = "";
        if (size != 0) {
            Node temp = head;
            while (temp != null) {
                str += temp.getData() + ", ";
                temp = temp.getNextlink();
            }
        }
        return str.substring(0, str.length() - 2);
    }
}
/**
 * class for node.
 */
class Node {
    /**
     * variable data of type int.
     */
    private int data;
    /**
     * variable nextlink of type Node.
     */
    private Node nextlink;
    /**
     * Constructs the object for Node.
     *
     * @param      val  The data
     */
    Node(final int val) {
        data = val;
        nextlink = null;
    }
    /**
     * Gets the value.
     *
     * @return     The value.
     */
    public int getData() {
        return data;
    }
    /**
     * Gets the next.
     *
     * @return     The next.
     */
    public Node getNextlink() {
        return nextlink;
    }
    /**
     * Sets the next.
     *
     * @param      value  The value
     */
    public void setNextlink(final Node value) {
        this.nextlink = value;
    }
}

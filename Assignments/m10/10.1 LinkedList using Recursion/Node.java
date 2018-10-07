/**
 * class for node.
 */
class Node {
    /**
     * description of variable data.
     */
    private int data;
    /**
     * description of variable nextlink.
     */
    private Node nextlink;
    /**
     * Constructs the object.
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

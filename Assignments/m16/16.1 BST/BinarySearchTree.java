/**
 * Class for binary search tree.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchTree<Key extends Comparable<Key>, Value> {
    /**
     * { variable root of type node }.
     */
    private Node root;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * { variable key of type Book }.
         */
        private Book key;
        /**
         * { variable value of type string}.
         */
        private String val;
        /**
         * { variable left of type node }.
         */
        private Node left;
        /**
         * { variable right of type node }.
         */
        private Node right;

        /**
         * Constructs the object for Node.
         *
         * @param      keys   The keys
         * @param      value  The value
         */
        Node(final Book keys, final String value) {
        this.key = keys;
        this.val = value;
        }
    }
    /**
     * Constructs the object for Binary serach tree.
     */
    BinarySearchTree() {
        root = null;
    }
    /**
     * { puts the value and key into binary search tree }.
     * The time complexity is N.
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Book key, final String val) {
        Node a = new Node(key, val);
        if (root == null) {
            root = a;
            return;
        }
        Node p = null;
        Node b = root;
        while (b != null) {
            p = b;
            int cmp = key.getBookname()
            .compareTo(b.key.getBookname());
            if (cmp < 0) {
                b = b.left;
            } else if (cmp > 0) {
                b = b.right;
            } else {
                b.val = val;
                return;
            }
        }
        int cmp = key.compareTo(p.key);
        if (cmp < 0) {
            p.left = a;
        } else {
            p.right = a;
        }
    }
    /**
     * {gives the value of given key }.
     * The time complexity is N.
     * @param      key   The key
     *
     * @return     { returns the value of given key }
     */
    public String get(final Book key) {
        Node b = root;
        while (b != null) {
            int cmp = key.getBookname()
            .compareTo(b.key.getBookname());
            if (cmp < 0) {
                b = b.left;
            } else if (cmp > 0) {
                b = b.right;
            } else {
                return b.val;
            }
        }
        return null;
    }
}

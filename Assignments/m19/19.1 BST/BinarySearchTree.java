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
        private int val;
        /**
        * { variable size of type int }.
        */
        private int size;
        /**
         * { variable left of type node }.
         */
        private Node left;
        /**
         * { variable right of type node }.
         */
        private Node right;
        /**
         * Constructs the object.
         *
         * @param      keys   The keys
         * @param      value  The value
         * @param      size1  The size 1
         */
        Node(final Book keys, final int value, final int size1) {
        this.key = keys;
        this.val = value;
        this.size = size1;
        left = null;
        right = null;
        }
    }
    /**
     * Constructs the object for Binary serach tree.
     */
    BinarySearchTree() {
        root = null;
    }
    /**
     * { function_description }.
     *.
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Book key, final int val) {
        root = put(root, key, val);
    }
    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     * @param      val   The value
     *
     * @return     { description_of_the_return_value }
     */
    private Node put(final Node x, final Book key, final int val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmpr = key.compareTo(x.key);
        if (cmpr < 0) {
            x.left = put(x.left, key, val);
        } else if (cmpr > 0) {
            x.right = put(x.right, key, val);
        } else if (cmpr == 0) {
            x.val = val;
        }
        return x;
    }
    /**
     * { function_description }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public int get(final Book key) {
        Node x = root;
        while (x != null) {
            int cmpr = key.compareTo(x.key);
            if (cmpr < 0) {
                x = x.left;
            } else if (cmpr > 0) {
                x = x.right;
            } else if (cmpr == 0) {
                return x.val;
            }
        }
        return -1;
    }
    /**
     * size function.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size(root);
    }
    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private int size(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public Book max() {
        return max(root).key;
    }
    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node max(final Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public Book min() {
        return min(root).key;
    }
    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node min(final Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }
    /**
     * { function_description }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Book ceiling(final Book key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Node ceiling(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int cmpr = key.compareTo(x.key);
        if (cmpr == 0) {
            return x;
        }
        if (cmpr < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return ceiling(x.right, key);
    }
    /**
     * { function_description }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Book floor(final Book key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Node floor(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int cmpr = key.compareTo(x.key);
        if (cmpr == 0) {
            return x;
        }
        if (cmpr <  0) {
            return floor(x.left, key);
        }
        Node p = floor(x.right, key);
        if (p != null) {
            return p;
        } else {
            return x;
        }
    }
    /**
     * { function_description }.
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Book select(final int k) {
        Node x = select(root, k);
        return x.key;
    }
    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node select(final Node x, final int k) {
        if (x == null) {
            return null;
        }
        int p = size(x.left);
        if (p > k) {
            return select(x.left,  k);
        } else if (p < k) {
            return select(x.right, k - p - 1);
        } else {
            return x;
        }
    }
}

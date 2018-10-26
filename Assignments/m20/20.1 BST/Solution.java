/**
 * { imports Scanner package }.
 */
import java.util.Scanner;
/**
 * class for Solution.
 */
public final class Solution {
    /**
     * Constructs the object for class Solution.
     */
    private Solution() {
      //default constructor.
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree<Book, Integer> bst =
        new BinarySearchTree<Book, Integer>();
        while (sc.hasNext()) {
            String[] token = sc.nextLine().split(",");
            switch (token[0]) {
            case "put":
                Book books = new Book(token[1],
                token[2], Float.parseFloat(token[2 + 1]));
                bst.put(books, Integer.parseInt(token[2 + 2]));
                break;
            case "get":
                books = new Book(token[1], token[2],
                Float.parseFloat(token[2 + 1]));
                if (bst.get(books) == null) {
                    System.out.println("null");
                } else {
                    System.out.println(bst.get(books));
                }
                break;
            case "max":
                System.out.println(bst.max());
                break;
            case "min":
                System.out.println(bst.min());
                break;
            case "floor":
                books = new Book(token[1],
                token[2], Float.parseFloat(token[2 + 1]));
                System.out.println(bst.floor(books));
                break;
            case "ceiling":
                books = new Book(token[1],
                token[2], Float.parseFloat(token[2 + 1]));
                System.out.println(bst.ceiling(books));
                break;
            case "select":
                System.out.println(bst.select(
                    Integer.parseInt(token[1])));
                break;
            case "deleteMax":
                bst.delMax();
            break;
            case "deleteMin":
                bst.delMin();
            break;
            case "delete":
                books = new Book(token[1], token[2],
                        Float.parseFloat(token[2 + 1]));
                bst.del(books);
            break;
            default:
            break;
            }
        }
    }
}

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
        private Key key;
        /**
         * { variable value of type string}.
         */
        private Value val;
        /**
         * { variable left of type node }.
         */
        private Node left;
        /**
         * { variable right of type node }.
         */
        private Node right;
        /**
        * { variable size of type int }.
        */
        private int size;
        /**
         * Constructs the object for Node.
         *
         * @param      keys   The keys
         * @param      value  The value
         * @param      size1  The size 1
         */
        Node(final Key keys, final Value value, final int size1) {
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
     * { puts the value and key into binary search tree }.
     * The time complexity is height of the tree.
     *.
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        root = put(root, key, val);
    }
    /**
     * { puts the value and key into binary search tree }.
     * The time complexity is height of the tree.
     *
     * @param      x     is key
     * @param      key   The key
     * @param      val   The value
     *
     * @return     { returns the value of given key }
     */
    private Node put(final Node x, final Key key, final Value val) {
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
     * {gives the value of given key }.
     * The time complexity is height of the tree.
     *
     * @param      key   The key
     *
     * @return     { returns the value of given key }
     */
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }
    /**
     * size function.
     * The time complexity is constant.
     * @return returns number of keys present in the bst.
     */
    public int size() {
        return size(root);
    }
    /**
     * gives the size.
     *
     * @param      x     is key
     * The time complexity is constant.
     * @return  returns number of keys present in it.
     */
    private int size(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }
    /**
     * { gives maximum key }.
     * The time complexity is height of the tree.
     * @return     { returns the largest key}
     */
    public Key max() {
        return max(root).key;
    }
    /**
     * { gives maximum key }.
     * The time complexity is height of the tree.
     * @param      x     { is key }
     *
     * @return     { returns the largest key }
     */
    private Node max(final Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }
    /**
     * { gives minimum key }.
     * The time complexity is height of the tree.
     * @return     { gives minimum key }
     */
    public Key min() {
        return min(root).key;
    }
    /**
     * { gives minimum key }.
     *
     * @param      x  the key.
     * The time complexity is height of the tree.
     * @return     { Returns the smallest key }
     */
    private Node min(final Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
    }
}
    /**
     * { gives the samllest key in.
     * the symbol table greater than or equal to key }.
     * The time complexity is height of the tree.
     * @param      key   The key
     *
     * @return   returns the smallest key
     * in the symbol table greater than or equal to key.
     */
    public Key ceiling(final Key key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * { gives the samllest key in.
     * the symbol table greater than or equal to key }.
     * the time complexity is height of the tree.
     * @param      x     the key
     * @param      key   The key
     *
     * @return     { returns the smallest key
     * in the symbol table greater than or equal to key.}
     */
    private Node ceiling(final Node x, final Key key) {
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
     * { gives the largest key in the symbol table.
     *  less than or equal to key }.
     * The time complexity is height of the tree.
     * @param      key   The key
     *
     * @return returns the largest key in the
     *  symbol table less than or equal to key.
     */
    public Key floor(final Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * { gives the largest key in the symbol table
     *  less than or equal to key }.
     * The time complexity is height of the tree.
     * @param      x     the key.
     * @param      key   The key
     *
     * @return  returns the largest key in the
     *  symbol table less than or equal to key.
     */
    private Node floor(final Node x, final Key key) {
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
     * {gives the key in the symbol table whose rank is k}.
     * The time complexity is height of the tree.
     * @param      k the key.
     *
     * @return {returns the key in the symbol table whose rank is k}
     */
    public Key select(final int k) {
        Node x = select(root, k);
        return x.key;
    }
    /**
     * {gives the key in the symbol table whose rank is k}.
     * The time complexity is height of the tree.
     * @param      x     the key.
     * @param      k     the order
     *
     * @return returns the key in the symbol table whose rank is k.
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
    /**
     * deletes minimum element.
     * The time complexity is height of the tree.
     */
    public void delMin() {
        root = delMin(root);
    }
    /**
     * deletes minimum element.
     * The time complexity is height of the tree.
     * @param      x  the key.
     *
     * @return  removes the smallest key and
     *  associated value from the symbol table.
     */
    private Node delMin(final Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = delMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * deletes the maximum element.
     * The time complexity is height of the tree.
     */
    public void delMax() {
        root = delMax(root);
    }
    /**
     * deletes the maximum element.
     * The time complexity is height of the tree.
     * @param      x  the key.
     *
     * @return removes the largest key and
     *  associated value from the symbol table
     */
    private Node delMax(final Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = delMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * deletes the specified key.
     * The time complexity is height of the tree.
     * @param      key   The key
     */
    public void del(final Key key) {
        root = del(root, key);
    }
    /**
     * deletes the specified key.
     * The time complexity is height of the tree.
     * @param      x     the key.
     * @param      key   The key
     *
     * @return  Removes the specified key and
     *  its associated value from this symbol table
     */
    private Node del(final Node x, final Key key) {
        Node y = x;
        if (y == null) {
            return null;
        }
        int cmp = key.compareTo(y.key);
        if (cmp < 0) {
            y.left  = del(y.left,  key);
        } else if (cmp > 0) {
            y.right = del(y.right, key);
        } else {
            if  (y.right == null) {
                return y.left;
            }
            if (y.left  == null) {
                return y.right;
            }
            Node t = y;
            y = min(t.right);
            y.right = delMin(t.right);
            y.left = t.left;
        }
        y.size = size(y.left) + size(y.right) + 1;
        return y;
    }
}

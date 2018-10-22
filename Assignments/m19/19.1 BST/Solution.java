import java.util.Scanner;
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
         * Constructs the object for Node.
         *
         * @param      keys   The keys
         * @param      value  The value
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
    public int Size() {
        return Size(root);
    }
    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private int Size(Node x) {
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
    public Book Max() {
        return Max(root).key;
    }
    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node Max(Node x) {
        if (x.right == null) {
            return x;
        } else {
            return Max(x.right);
        }
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public Book Min() {
        return Min(root).key;
    }
    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node Min(Node x) {
        if (x.left == null) {
            return x;
        } else {
            return Min(x.left);
        }
    }
    /**
     * { function_description }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Book Ceiling(Book key) {
        Node x = Ceiling(root, key);
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
    private Node Ceiling(Node x, Book key) {
        if (x == null) {
            return null;
        }
        int cmpr = key.compareTo(x.key);
        if (cmpr == 0) {
            return x;
        }
        if (cmpr < 0) {
            Node t = Ceiling(x.left, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return Ceiling(x.right, key);
    }
    /**
     * { function_description }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Book Floor(Book key) {
        Node x = Floor(root, key);
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
    private Node Floor(Node x, Book key) {
        if (x == null) {
            return null;
        }
        int cmpr = key.compareTo(x.key);
        if (cmpr == 0) {
            return x;
        }
        if (cmpr <  0) {
            return Floor(x.left, key);
        }
        Node p = Floor(x.right, key);
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
    public Book Select(int k) {
        Node x = Select(root, k);
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
    private Node Select(Node x, int k) {
        if (x == null) {
            return null;
        }
        int p = Size(x.left);
        if (p > k) {
            return Select(x.left,  k);
        } else if (p < k) {
            return Select(x.right, k - p - 1);
        } else {
            return x;
        }
    }
}
/**
 * solution class.
 */
public final class Solution {
    /**
     * Constructs the booksect.
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
        BinarySearchTree bst = new BinarySearchTree();
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
                if (bst.get(books) == -1) {
                    System.out.println("null");
                } else {
                    System.out.println(bst.get(books));
                }
                break;
            case "max":
                System.out.println(bst.Max());
                break;
            case "min":
                System.out.println(bst.Min());
                break;
            case "floor":
                books = new Book(token[1],
                token[2], Float.parseFloat(token[2 + 1]));
                System.out.println(bst.Floor(books));
                break;
            case "ceiling":
                books = new Book(token[1],
                token[2], Float.parseFloat(token[2 + 1]));
                System.out.println(bst.Ceiling(books));
                break;
            case "select":
                System.out.println(bst.Select(
                    Integer.parseInt(token[1])));
                break;
            default:
                break;
            }
        }
    }
}

/**
 * { imports Scanner package }.
 */
import java.util.Scanner;
/**
 * Class for book.
 */
class Book implements Comparable<Book> {
    /**
     * { variable bookname of type string }.
     */
    private String bookname;
    /**
     * { variable authorname of type string }.
     */
    private String authorname;
    /**
     * { variable price of type double }.
     */
    private double price;

    /**
     * Constructs the object for the class book.
     *
     * @param      name    The name
     * @param      author  The author
     * @param      cost    The cost
     */
    Book(final String name, final String author, final double cost) {
        this.bookname = name;
        this.authorname = author;
        this.price = cost;
    }
    /**
     * Gets the bookname.
     *
     * @return     The bookname.
     */
    public String getBookname() {
        return this.bookname;
    }
    /**
     * Gets the authorname.
     *
     * @return     The authorname.
     */
    public String getAuthorname() {
        return this.authorname;
    }
    /**
     * Gets the price.
     *
     * @return     The price.
     */
    public double getPrice() {
        return this.price;
    }
    /**
     * { compares two objects }.
     *
     * @param      that  The that
     *
     * @return returns 1 if this.bookname is gretaer
     * or -1 if that.bookname is gretaer otherwise returns 0.
     */
    public int compareTo(final Book that) {
        return this.getBookname().compareTo(that.getBookname());
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
/**
 * class for Solution.
 */
public final class Solution {
    /**
     * Constructs the object for class Solution.
     */
    private Solution() {
        // unused constructor.
    }
    /**
     * main function.
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
                Book book = new Book(token[1], token[2],
                    Double.parseDouble(token[2 + 1]));
                bst.put(book, token[2 + 2]);
                break;
                case "get":
                book = new Book(token[1], token[2],
                    Double.parseDouble(token[2 + 1]));
                System.out.println(bst.get(book));
                break;
                default:
                break;
            }
        }
    }
}

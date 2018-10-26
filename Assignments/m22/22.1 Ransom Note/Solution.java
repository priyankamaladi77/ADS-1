import java.util.Iterator;
/**
 * imports Scanner package.
 */
import java.util.Scanner;
/**
 * class for solution.
 */
public final class Solution {
    /**
     * Constructs the object for class solution.
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
        SeparateChainingHashST<String, Integer> obj
        = new SeparateChainingHashST<String, Integer>();
        String[] words = sc.nextLine().split(" ");
        String[] line1 = sc.nextLine().split(" ");
        for (int i = 0; i < line1.length; i++) {
            if (obj.contains(line1[i])) {
                obj.put(line1[i], obj.get(line1[i]) + 1);
            } else {
                obj.put(line1[i], 1);
            }
        }
        String[] line2 = sc.nextLine().split(" ");
        for (int i = 0; i < line2.length; i++) {
            if (obj.contains(line2[i])) {
                if (obj.get(line2[i]) == 0) {
                    System.out.println("No");
                    return;
                } else {
                    obj.put(line2[i], obj.get(line2[i]) - 1);
                }
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
/**
 * Class for sequential search st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class SequentialSearchST<Key, Value> {
    /**
     * { var_description }.
     */
    private int n;
    /**
     * { var_description }.
     */
    private Node first;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * { var_description }.
         */
        private Key key;
        /**
         * { var_description }.
         */
        private Value val;
        /**
         * { var_description }.
         */
        private Node next;

        /**
         * Constructs the object.
         *
         * @param      key1   The key 1
         * @param      val1   The value 1
         * @param      next1  The next 1
         */
        public Node(final Key key1, final Value val1,
        final Node next1)  {
            this.key  = key1;
            this.val  = val1;
            this.next = next1;
        }
    }
    /**
     * Initializes an empty symbol table.
     */
    SequentialSearchST() {
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param      key   the key
     *
     * @return     {@code true} if this symbol table contains {@code key};
     *             {@code false} otherwise
     */
    public boolean contains(final Key key) {
        return get(key) != null;
    }

    /**
     * Returns the value associated with the given key in this symbol table.
     *
     * @param      key   the key
     *
     * @return     the value associated with the given key if the key is in the
     *             symbol table and {@code null} if the key is not in the symbol
     *             table
     */
    public Value get(final Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting
     * the old value with the new value if the symbol table already contains the
     * specified key. Deletes the specified key (and its associated value) from
     * this symbol table if the specified value is {@code null}.
     *
     * @param      key   the key
     * @param      val   the value
     */
    public void put(final Key key, final Value val) {
        if (val == null) {
            delete(key);
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }

    /**
     * Removes the specified key and its associated value from this symbol table
     * (if the key is in this symbol table).
     *
     * @param      key   the key
     */
    public void delete(final Key key) {
        first = delete(first, key);
    }

    // delete key in linked list beginning at Node x
    // warning: function call stack too large if table is large
    private Node delete(final Node x, final Key key) {
        if (x == null) {
            return null;
        }
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }


    /**
     * Returns all keys in the symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in the symbol table
     */
    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next) {
            queue.enqueue(x.key);
        }
        return queue;
    }
}

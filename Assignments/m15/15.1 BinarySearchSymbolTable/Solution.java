import java.util.NoSuchElementException;
/**
 * { importing scanner package }.
 */
import java.util.Scanner;
/**
 * class for Solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused constructor.
    }
    /**
     * client program for Binary search Symbol table.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchSymbolTable<String, Integer> st = new
        BinarySearchSymbolTable<String, Integer>();
        String[] tokens = sc.nextLine().split(" ");
        for (int i = 0; i < tokens.length; i++) {
            st.put(tokens[i], i);
        }
        while (sc.hasNext()) {
            String[] check = sc.nextLine().split(" ");
            switch (check[0]) {
                case "max":
                    System.out.println(st.max());
                    break;
                case "floor":
                    System.out.println(st.floor(check[1]));
                    break;
                case "rank":
                    System.out.println(st.rank(check[1]));
                    break;
                case "deleteMin":
                    st.delMin();
                    break;
                case "contains":
                    System.out.println(st.contains(tokens[1]));
                    break;
                case "keys":
                    System.out.println(st);
                    break;
                case "get":
                    System.out.println(st.get(check[1]));
                    break;
                default:
                    break;
            }
        }
    }
}

/**
 * Class for symbol table.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchSymbolTable<Key extends Comparable<Key>, Value> {
    /**
     * { key array of type Key }.
     */
    private Key[] key;
    /**
     * { val array of type value }.
     */
    private Value[] val;
    /**
     * { variable num of type integer }.
     */
    private int num = 0;
    /**
     * { varaiable capacity }.
     */
    private static final int CAPACITY = 2;
    /**
     * Constructs the object for BinarySearchSymbolTable.
     */
    BinarySearchSymbolTable() {
        this(CAPACITY);
    }
    /**
     * Constructs the object for symbol table.
     *
     * @param      capacity  The capacity
     */
    BinarySearchSymbolTable(final int capacity) {
        key = (Key[]) new Comparable[capacity];
        val = (Value[]) new Object[capacity];
    }
    /**
     * { resizes the array  }.
     * The time complexity is O(N) because the
     * statments in the for loop iterates for N times.
     * @param      capacity  The capacity
     */
    private void resize(final int capacity) {
        Key[] k = (Key[]) new Comparable[capacity];
        Value[] v = (Value[]) new Object[capacity];
        for (int i = 0; i < num; i++) {
            k[i] = key[i];
            v[i] = val[i];
        }
        val = v;
        key = k;
    }
    /**
     * { gives size of array }.
     * The time complexity is constant because
     * the statment executes only once.
     * @return  returns size of array.
     */
    public int size() {
        return num;
    }
    /**
     * Determines if empty.
     * The time complexity is constant because
     * the statment executes only once.
     * @return    returns true if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * { checks whether the key is present int the array }.
     *
     * @param      keys  The keys
     *
     * @return  returns true if key is present otherwise false.
     */
    public boolean contains(final Key keys) {
        if (keys == null) {
        throw new IllegalArgumentException("argument to contains() is null");
        }
        return get(keys) != null;
    }
    /**
     * { gives the rank }.
     *
     * @param      keys  The keys
     *
     * @return   returns index low.
     */
    public int rank(final Key keys) {
        if (keys == null) {
            throw new IllegalArgumentException("argument to rank() is null");
        }
        int low = 0, high = num - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = keys.compareTo(key[mid]);
            if (cmp < 0) {
            high = mid - 1;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
    /**
     * { gets the value of key }.
     *
     * @param      keys  The keys
     *
     * @return  returns value of the given key.
     */
    public Value get(final Key keys) {
        if (keys == null) {
            throw new IllegalArgumentException("argument to get() is null");
        }
        if (isEmpty()) {
            return null;
        }
        int i = rank(keys);
        if (i < num && key[i].compareTo(keys) == 0) {
            return val[i];
        }
        return null;
    }
    /**
     * { updates the value of key }.
     *
     * @param      keys  The keys
     * @param      valu  The valu
     */
    public void put(final Key keys, final Value valu)  {
        if (keys == null) {
            throw new IllegalArgumentException(
            "first argument to put() is null");
        }

        if (valu == null) {
            delete(keys);
            return;
        }

        int i = rank(keys);
        if (i < num && key[i].compareTo(keys) == 0) {
            val[i] = valu;
            return;
        }

        if (num == key.length) {
            resize(2 * key.length);
        }

        for (int j = num; j > i; j--)  {
            key[j] = key[j - 1];
            val[j] = val[j - 1];
        }
        key[i] = keys;
        val[i] = valu;
        num++;
        assert check();
    }
    /**
     * { deletes the key }.
     *
     * @param      keys  The keys
     */
    public void delete(final Key keys) {
        if (keys == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        if (isEmpty()) {
            return;
        }

        // compute rank
        int i = rank(keys);

        // key not in table
        if (i == num || key[i].compareTo(keys) != 0) {
            return;
        }

        for (int j = i; j < num - 1; j++)  {
            key[j] = key[j + 1];
            val[j] = val[j + 1];
        }

        num--;
        key[num] = null;  // to avoid loitering
        val[num] = null;

        // resize if 1/4 full
        if (num > 0 && num == key.length / (2 + 2)) {
            resize(key.length / 2);
        }
        assert check();
    }
    /**
     * { deletes the minimum value in array }.
     */
    public void delMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table underflow error");
        }
        delete(min());
    }
    /**
     * { deletes the maximum key value in the array }.
     */
    public void delMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table underflow error");
        }
        delete(max());
    }
    /**
     * { find outs minimum key }.
     *
     * @return returns the value of minimum key.
     */
    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "called min() with empty symbol table");
        }
        return key[0];
    }
    /**
     * { find outs the maximum key }.
     *
     * @return returns the value of maximum key.
     */
    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "called max() with empty symbol table");
        }
        return key[num - 1];
    }
    /**
     * { selects a specified key }.
     *
     * @param      k     { parameter_description }
     *
     * @return returns the value of specified key.
     */
    public Key select(final int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException(
                "called select() with invalid argument: " + k);
        }
        return key[k];
    }
    /**
     * { function_description }.
     *
     * @param      keys  The keys
     *
     * @return  returns key value.
     */
    public Key floor(final Key keys) {
        if (keys == null) {
            throw new IllegalArgumentException("argument to floor() is null");
        }
        int i = rank(keys);
        if (i < num && keys.compareTo(key[i]) == 0) {
            return key[i];
        }
        if (i == 0) {
            return null;
        } else {
            return key[i - 1];
        }
    }
    /**
     * { function_description }.
     *
     * @param      lo    The lower
     * @param      hi    The higher
     *
     * @return     { description_of_the_return_value }
     */
    public int size(final Key lo, final Key hi) {
        if (lo == null) {
            throw new IllegalArgumentException(
                "first argument to size() is null");
        }
        if (hi == null) {
            throw new IllegalArgumentException(
                "second argument to size() is null");
        }
        if (lo.compareTo(hi) > 0) {
            return 0;
        }
        if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else {
            return rank(hi) - rank(lo);
        }
    }
     /**
      * checks whether array is sorted or not.
      *
      * @return true if array is soretd otherwise false.
      */
     private boolean check() {
        return isSorted() && rankCheck();
    }
    /**
     * Determines if sorted.
     *
     * @return     True if sorted, False otherwise.
     */
    private boolean isSorted() {
        for (int i = 1; i < size(); i++) {
            if (key[i].compareTo(key[i - 1]) < 0)  {
                return false;
            }
        }
        return true;
    }
    /**
     * { checks the rank }.
     *
     * @return true if rank is checked otherwise false.
     */
    private boolean rankCheck() {
        for (int i = 0; i < size(); i++) {
            if (i != rank(select(i))) {
                return false;
            }
        }
        for (int i = 0; i < size(); i++) {
            if (key[i].compareTo(select(rank(key[i]))) != 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        int i = 0;
        for (i = 0; i < size() - 1; i++) {
            str += key[i] + " " + val[i] + "\n";
        }
        str += key[i] + " " + val[i];
        return str;
    }
}

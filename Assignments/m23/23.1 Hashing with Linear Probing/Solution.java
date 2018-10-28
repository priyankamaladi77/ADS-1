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
     * main method for linear probing hash St.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        LinearProbingHashST<String, Integer> hst = new
        LinearProbingHashST<String, Integer>();
        for (int i = 0; i < num; i++) {
            String[] token = sc.nextLine().split(" ");
            switch (token[0]) {
            case "put":
                hst.put(token[1], Integer.parseInt(token[2]));
                break;
            case "get":
                System.out.println(hst.get(token[1]));
                break;
            case "delete":
                hst.delete(token[1]);
                break;
            case "display":
                hst.display();
                break;
            default:
                break;
            }
        }
    }
}
/**.
 * Class for linear probing hash st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class LinearProbingHashST<Key, Value> {
    /**
     * variable capacity of type int.
     */
    private static final int INIT_CAPACITY = 4;
    /**
     * variable n number of key value pairs of type int. 
     */
    private int n;
    /**
     * variable m of type int.
     */
    private int m;
    /**
     * keys of Key array.
     */
    private Key[] keys;
    /**
     * values of Value type.
     */
    private Value[] vals;
    /**
     * Initializes an empty symbol table.
     */
    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }
    /**
     * Initializes an empty symbol table with the specified initial capacity.
     *
     * @param capacity the initial capacity
     */
    public LinearProbingHashST(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *  the time complexity is constant as
     *  each statement is executed only once.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }
    /**
     * hash funciton.
     * The time complexity is constant as
     * each statement is executed only once.
     * @param      key   The key
     *
     * @return     {hash number of int tuype }
     */
    private int hash(Key key) {
        return (key.hashCode() * 11) % m;
    }
    /**
     * checks if the key contains or not.
     * The time complexity is constant as
     * each statement is executed only once.
     * @param      key   The key
     *
     * @return     { returns true if key contained else false}
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    /**
     * resizes the array.
     * The time complexity is N as loop iterates till end.
     * @param      capacity  The capacity
     */
    private void resize(int capacity) {
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m    = temp.m;
    }
    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old
     * The time complexity is constant.
     * @param      key   The key
     * @param      val   The value
     */
    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        if (n >= m / 2) resize(2 * m);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }
    /**
     * Returns the value associated with the specified key.
     * The time complexity is constant.
     * @param      key   The key
     *
     * @return     {gets value of Key of value type }
     */
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }
    /**
     * Removes the specified key and its associated value from this symbol table
     * The time complexity is constant.
     * @param      key   The key
     */
    public void delete(Key key) {
        if (!contains(key)) return;

        // find position i of key
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }
        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % m;
        while (keys[i] != null) {
            Key   keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }

        n--;

        // halves size of array if it's 12.5% full or less
        if (n > 0 && n <= m / 8) resize(m / 2);
    }
    /**
     * Displays the hash table in dictonary format.
     * The time complexity is constant.
     */
     public void display() {
        if(size() == 0) {
            System.out.println("{}");
            return;
        }
        String str = "{";
        for(int i=0; i<keys.length;i++) {
            if(keys[i] != null) {
                str += keys[i] + ":" + vals[i] + ", ";
            }
        }
        str = str.substring(0, str.length()-2);
        str += "}";
        System.out.println(str);
    }
}

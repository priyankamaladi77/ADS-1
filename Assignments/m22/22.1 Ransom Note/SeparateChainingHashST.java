/**
 * Class for separate chaining hash st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class SeparateChainingHashST<Key, Value> {
    /**
     * { variable INIT_CAPACITY of type int }.
     */
    private static final int INIT_CAPACITY = 4;
    /**
     * { variable n of type int }.
     */
    private int n;
    /**
     * { variable m of type int}.
     */
    private int m;
    /**
     * { variable NUM of type int }.
     */
    private static final int NUM = 0x7fffffff;
    /**
     * { variable st of type sequentialSearchST }.
     */
    private SequentialSearchST<Key, Value>[] st;
    /**
     * Initializes an empty symbol table.
     */
    SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }
    /**
     * Initializes an empty symbol table with {@code m} chains.
     * @param m1 the initial number of chains
     */
    SeparateChainingHashST(final int m1) {
        this.m = m1;
        st = (SequentialSearchST<Key, Value>[])
        new SequentialSearchST[m];
        for (int i = 0; i < m; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }
    /**
     * resize the hash table to have the given number of chains.
     * rehashing all of the keys
     * Time complexity is N as the loop iterates
     * through the size of hash table.
     * @param      chains  The chains
     */
    private void resize(final int chains) {
        SeparateChainingHashST<Key, Value> temp =
        new SeparateChainingHashST<Key, Value>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m  = temp.m;
        this.n  = temp.n;
        this.st = temp.st;
    }
    /**
     * { hash value between 0 and m-1 }.
     *
     * @param      key   The key
     * Time compleixtyn is constant as each statement is executed only once.
     * @return returns hash value between 0 and m-1
     */
    private int hash(final Key key) {
        return (key.hashCode() & (NUM % m));
    }
    /**
     * Returns the number of key-value pairs in this symbol table.
     * Time compleixty is constant as each statement is executed only once.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }
    /**
     * Returns true if this symbol table is empty.
     * Time compleixty is constant as each statement is executed only once.
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * Returns true if this symbol table contains the specified key.
     * Time compleixty is constant as each statement is executed only once
     * @param      key   the key
     *
     * @return     {@code true} if this symbol table contains {@code key};
     *             {@code false} otherwise
     */
    public boolean contains(final Key key) {
        return get(key) != null;
    }
    /**
     * Returns the value associated with the specified key in this symbol table.
     * Time complexity is constant.
     * @param      key   the key
     *
     * @return     the value associated with {@code key} in the symbol table;
     *             {@code null} if no such value
     */
    public Value get(final Key key) {
        int i = hash(key);
        return st[i].get(key);
    }
    /**
     * Inserts the specified key-value pair into the. symbol table, overwriting
     * the old value with the new value if the symbol table already contains the
     * specified key. Deletes the specified key (and its associated value) from
     * this symbol table if the specified value is {@code null}.
     * Time complexity is constant.
     * @param      key   the key
     * @param      val   the value
     */
    public void put(final Key key, final Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        // double table size if average length of list >= 10
        if (n >= (2 + 2 + 2 + 2 + 2) * m) {
            resize(2 * m);
        }

        int i = hash(key);
        if (!st[i].contains(key)) {
            n++;
        }
        st[i].put(key, val);
    }
    /**
     * Removes the specified key and its associated
     * value from this symbol table
     * (if the key is in this symbol table).
     * Time complexity is constant.
     * @param      key   The key
     */
    public void delete(final Key key) {
        int i = hash(key);
        if (st[i].contains(key)) {
            n--;
        }
        st[i].delete(key);
        // halve table size if average length of list <= 2
        if (m > INIT_CAPACITY && n <= 2 * m) {
            resize(m / 2);
        }
    }
    /**
     * { gives keys in symbol table as an Iterable }.
     * @return returns keys in symbol table as an Iterable
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                queue.enqueue(key);
            }
        }
        return queue;
    }
}

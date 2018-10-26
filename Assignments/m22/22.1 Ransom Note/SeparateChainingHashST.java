/**
 * Class for separate chaining hash st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class SeparateChainingHashST<Key, Value> {
    /**
     * { var_description }.
     */
    private static final int INIT_CAPACITY = 4;
    /**
     * { var_description }.
     */
    private int n;
    /**
     * { var_description }.
     */
    private int m;
    /**
     * { var_description }.
     */
    private static final int NUM = 0x7fffffff;
    /**
     * { var_description }.
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
     * { function_description }.
     *
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
     * { function_description }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private int hash(final Key key) {
        return (key.hashCode() & (NUM % m));
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
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key};
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(final Key key) {
        return get(key) != null;
    }
    /**
     * Returns the value associated with the specified key in this symbol table.
     *
     * @param  key the key
     * @return the value associated with {@code key} in the symbol table;
     *         {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(final Key key) {
        int i = hash(key);
        return st[i].get(key);
    }
    /**
     * Inserts the specified key-value pair into the.
     *  symbol table, overwriting the old
     * value with the new value if the symbol table
     *  already contains the specified key.
     * Deletes the specified key (and its associated
     *  value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
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
     * { function_description }.
     *
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
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
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

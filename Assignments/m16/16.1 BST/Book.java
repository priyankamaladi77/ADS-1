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

/**
 * Class for taxi cab numbers.
 */
class TaxiCabNumbers implements Comparable<TaxiCabNumbers> {
    /**
     * variable sum of type long.
     */
    private long sum;
    /**
     * variable i of type integer.
     */
    private int i;
    /**
     * variable j of type integer.
     */
    private int j;

    /**
     * Constructs the object for Taxi Cab Numbers.
     *
     * @param      i1    I 1
     * @param      j1    The j 1
     */
    TaxiCabNumbers(final int i1, final int j1) {
        this.sum = (long) (i1 * i1 * i1) + (j1 * j1 * j1);
        this.i = i1;
        this.j = j1;
    }
    /**
     * compares two objects.
     * Time complexity is constant as each statment executes only one.
     * @param      that  The that
     *
     * @return returns 1, -1 and 0 based on comparision.
     */
    public int compareTo(final TaxiCabNumbers that) {
        if (this.sum > that.sum) {
            return +1;
        }
        if (this.sum < that.sum) {
            return -1;
        }
        if (this.i > that.i) {
            return +1;
        }
        if (this.i < that.i) {
            return -1;
        }
        return 0;
    }
    /** The time complexity is constant because only
     * one statment is executed.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return sum  + " : " + i + "^3 + " + j + "^3";
    }
    /**
     * To find the Taxi can numbers.
     * The time complexity is O(N) because for loop executes for N times.
     * @param      nth    number of accurance of taxicabnumber.
     * @param      mpair  number of pairs needed.
     *
     * @return     returns taxicabnumber.
     */
    public static long findTaxiCabNumbers(final int nth, final int mpair) {
        MinPQ<TaxiCabNumbers> minPQ = new MinPQ<TaxiCabNumbers>();
        final int n = 600;
        int count = 0;
        long result = 0;
        for (int i = 1; i <= n; i++) {
            minPQ.insert(new TaxiCabNumbers(i, i));
        }

        TaxiCabNumbers previous = new TaxiCabNumbers(0, 0);

        int run = 1;
        while (!minPQ.isEmpty()) {
            TaxiCabNumbers current = minPQ.delMin();
            if (previous.sum == current.sum) {
                run = run + 1;
                if (run == mpair) {
                    count++;
                    if (count == nth) {
                        result = current.sum;
                        break;
                    }
                }
            } else {
                run = 1;
            }
            if (current.j < n) {
                minPQ.insert(new TaxiCabNumbers(current.i, current.j + 1));
            }
            previous = current;
        }
        return result;
    }
}

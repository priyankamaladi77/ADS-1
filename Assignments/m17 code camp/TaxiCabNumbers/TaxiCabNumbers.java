class TaxiCabNumbers implements Comparable<TaxiCabNumbers> {
	private long sum;
	private int i;
	private int j;

	TaxiCabNumbers(int i1, int j1) {
		this.sum = (long)(i1 * i1 * i1) + (j1 * j1 * j1);
		this.i = i1;
		this.j = j1;
	}
	public int compareTo(TaxiCabNumbers that) {
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
	public String toString() {
		return sum  + " : " + i + "^3 + " + j + "^3";
	}
	public static long findTaxiCabNumbers(final int nth, final int mpair) {
        MinPQ<TaxiCabNumbers> minPQ = new MinPQ<TaxiCabNumbers>();
        final int n = 600;
        int count = 0;
        long result = 0;
        for (int i = 1; i <= nth; i++) {
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
            if (current.j < nth) {
                minPQ.insert(new TaxiCabNumbers(current.i, current.j + 1));
            }
            previous = current;
        }
        return result;
    }
}

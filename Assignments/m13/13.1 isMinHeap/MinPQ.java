class MinPQ<Q extends Comparable<Q>> {
	private Q[] arr;
	MinPQ(final Q[] array) {
		this.arr = array;
	}
	public boolean isMinPQ() {
		for (int k = 1; k < arr.length - 1; k++) {
			if (less(2*k , k) && less(2*k + 1, k)) {
				return false;
			}
		}
		return true;
	}
	public boolean less(final int v, final int w) {
		return arr[v].compareTo(arr[w]) < 0;
	}
}

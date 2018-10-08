class MinPQ<Q extends Comparable<Q>> {
	private Q[] arr;
	MinPQ(final Q[] array) {
		this.arr = array;
	}
	public boolean isMinPQ() {
		for (int i = 0; i < arr.length - 1; i++) {
			if (less(2*i + 1, 2*i)) {
				return false;
			}
		}
		return true;
	}
	public boolean less(final int v, final int w) {
		return arr[v].compareTo(arr[w]) < 0;
	}
}

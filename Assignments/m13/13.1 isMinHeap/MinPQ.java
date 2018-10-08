class MinPQ<Q extends Comparable<Q>> {
	private Q[] arr;
	MinPQ(final Q[] array) {
		this.arr = array;
	}
	public boolean isMinPQ() {
		for (int i = 1; i < arr.length - 1; i++) {
			if (less(i + 1, i)) {
				return false;
			}
		}
		return true;
	}
	public boolean less(final int v, final int w) {
		return arr[v].compareTo(arr[w]) < 0;
	}
}

class Selection {
	Selection() {
	}
	private static void exchange(Comparable[] arr, int i, int min) {
		Comparable swap = arr[i];
		arr[i] = arr[min];
		arr[min] = swap;
	}
	private static boolean less(Comparable v, Comparable w) {
		 return (v.compareTo(w)) < 0;
	}
	public static void sort(Comparable[] arr) {
		int num = arr.length;
		for (int i = 0; i < num; i++) {
			int min = i;
			for (int j = i + 1; j < num; j++) {
				if (less(arr[j], arr[min])) {
					min = j;
				}
			}
			exchange(arr, i, min);
		}
	}
}

class Insertion {
	Insertion() {
	}
	private static void exchange(Comparable[] arr, int i, int j) {
		Comparable swap = arr[i];
		arr[i] = arr[j];
		arr[j] = swap;
	}
	private static boolean less(Comparable v, Comparable w) {
		 return (v.compareTo(w)) < 0;
	}
	public static void sort(Comparable[] arr) {
		int num = arr.length;
		for (int i = 0; i < num; i++) {
			for (int j = i; j > 0; j--) {
				if (less(arr[j], arr[j - 1])) {
					exchange(arr, j, j - 1);
				} else {
					break;
				}
			}	
		}
	}
}

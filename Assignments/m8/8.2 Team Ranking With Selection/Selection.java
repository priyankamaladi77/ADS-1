/**
 * Class for selection.
 */
final class Selection {
    /**
     * Constructs the object of selection sort.
     */
    private Selection() {
    }
    /**
     * { exchanges the elements in ith index with min index}.
     * Time complexity : 1
     * @param      arr   comparable array
     * @param      i     { index }
     * @param      min   index
     */
    private static void exchange(final Comparable[] arr,
            final int i, final int min) {
        Comparable swap = arr[i];
        arr[i] = arr[min];
        arr[min] = swap;
    }
    /**
     * { function for comparing two objects }.
     *
     * @param      v     { Comparable object }
     * @param      w     { Comparable object }
     *
     * @return     { returns -1 if condition is satisfied else returns 1 }
     */
    private static boolean less(final Comparable v, final Comparable w) {
         return (v.compareTo(w)) < 0;
    }
    /**
     * { sorts all the elements in an array using selection sort }.
     *
     * @param      arr   comparable array
     */
    public static void sort(final Comparable[] arr) {
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

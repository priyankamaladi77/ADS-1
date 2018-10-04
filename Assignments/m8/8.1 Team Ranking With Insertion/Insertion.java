/**
 * Class for Insertion.
 */
final class Insertion {
    /**
     * Constructs the object of insertion sort.
     */
    private Insertion() {
        //empty constructor.
    }
    /**
     * { exchanges the elements in ith index with min index}.
     * Time complexity : constant
     * @param      arr   comparable array
     * @param      i     { index }
     * @param      j   index
     */
    private static void exchange(final Comparable[] arr,
        final int i, final int j) {
        Comparable swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
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
     * { sorts all the elements in an array using insertion sort }.
     *
     * @param      arr   comparable array
     */
    public static void sort(final Comparable[] arr) {
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

/**
 * Class for minimum pq.
 *
 * @param      <Q>   The quarter
 */
class MinPQ<Q extends Comparable<Q>> {
    /**
     * pq array of Q type.
     */
    private Q[] arr;
    /**
     * Constructs the object for class minPQ.
     *
     * @param      array  The array
     */
    MinPQ(final Q[] array) {
        this.arr = array;
    }
    /**
     * checks if array is minPQ or not.
     *
     * @return    returns True if minimum pq, False otherwise.
     * The time complexity is N because it iterates for N times in the loop.
     */
    public boolean isMinPQ() {
        // for (int k = 1; k < arr.length - 1; k++) {
        //  if (less(2*k , k) && less(2*k + 1, k)) {
        for (int k = 1; k < arr.length / 2; k++) {
                if ((less(k, 2 * k)) && (less(k, 2 * k + 1))) {
                    return false;
                }
            }
            return true;
        }
    /**
     * compares two elements of Q array.
     *
     * @param      v     { index of array }
     * @param      w     { index of array }
     *
     * @return  returns true if condition is satisfied fasle otherwise.
     * The time complexity is constant because the statment is executed once.
     */
    public boolean less(final int v, final int w) {
        return arr[v].compareTo(arr[w]) < 0;
    }
}

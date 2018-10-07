import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for merge sort.
 */
class Mergesort {
    /**.
     * final variable.
     */
    private final int cut = 7;
    /**.
     * int arr size variable.
     */
    private int[] arr;
    /**
     * size variable.
     */
    private int size;
    /**
     * Constructs the object.
     * Time complexity is constant.
     */
    Mergesort() {
        this.arr = new int[1];
        this.size = 0;
    }
    /**
     * Gets the size.
     * Time complexity is constant.
     *
     * @return     returns the size.
     */
    public int getSize() {
        return this.size;
    }
    /**
     * to resize the gievn array.
     * Time complexity is N.
     */
    private void resize() {
        arr = Arrays.copyOf(arr, 2 * arr.length);
    }
    /**
     * to add the elements into the array.
     * Time complexity is constant.
     *
     * @param      item  The item
     */
    public void add(final int item) {
        if (size == arr.length) {
            resize();
        }
        arr[size++] = item;
    }
    /**
     * Rearranges the arr in ascending order, using the natural order.
     *
     * @param      a     Comparable object.
     * Time complexity is O(N).
     */
    public void sort(final Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
        assert isSorted(a);
    }
    /**
     * insertion sort. Time complexity is O(N).
     *
     * @param      a     { comparable array }
     * @param      lo    The lower index
     * @param      hi    The higher index
     */
    public void insertionSort(final Comparable[] a,
        final int lo, final int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
    /**
     * to exchage or to swap.
     * Time complexity is O(N).
     *
     * @param      a     { object array }
     * @param      i     { index }
     * @param      j     { index }
     */
    public void exch(final Object[] a, final int i, final int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    /**
     * to check two comparable objects.
     * Time complexity is constant.
     *
     * @param      a     { comparable object }
     * @param      b     { comparable object }
     *
     * @return     returns true or false based on the condition.
     */
    public boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
    /**
     * Determines if sorted.
     * Time complexity is constant.
     *
     * @param      a     { comparable array }
     *
     * @return     returns true if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }
    /**
     * Determines if sorted.
     * Time complexity is O(log(N)).
     *
     * @param      a     { comparable array }
     * @param      lo    The lower
     * @param      hi    The higher
     *
     * @return   returns true if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] a, final int lo,
        final int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
    /**
     * to merge the data.
     * Time complexity is O(N).
     *
     * @param      arr1  The array
     * @param      aux    The auxiliary array
     * @param      lo     The lower
     * @param      mid    The middle
     * @param      hi     The higher
     */
    public void merging(final Comparable[] arr1,
        final Comparable[] aux, final int lo, final int mid, final int hi) {
        assert isSorted(arr1, lo, mid);
        assert isSorted(arr1, mid + 1, hi);
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                aux[k] = arr1[j++];
            } else if (j > hi) {
                aux[k] = arr1[i++];
            } else if (less(arr1[j], arr1[i])) {
                aux[k] = arr1[j++];
            } else {
                aux[k] = arr1[i++];
            }
        }
        assert isSorted(aux, lo, hi);
    }
    /**
     * To sort. Time complexity is O(Log(N)).
     *
     * @param      arr2  The array
     * @param      aux    The auxiliary
     * @param      lo     The lower
     * @param      hi     The higher
     */
    public void sort(final Comparable[] arr2,
        final Comparable[] aux, final int lo, final int hi) {
        if (hi <= lo + cut) {
            insertionSort(aux, lo, hi);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(aux, arr2, lo, mid);
        sort(aux, arr2, mid + 1, hi);
        if (!less(arr2[mid + 1], arr2[mid])) {
            for (int i = lo; i <= hi; i++) {
                aux[i] = arr2[i];
            }
            System.out.println(
            "Array is already sorted. So, skipped the call to merge...");
            return;
        }
        merging(arr2, aux, lo, mid, hi);
    }
    /**.
     * { displays the result }
     *
     * @param      a     { array object }
     *
     * @return     returns value of s.
     */
    public Object display(final Object[] a) {
        String s = "[";
        int i;
        for (i = 0; i < a.length - 1; i++) {
            s += a[i] + ", ";
        }
        s += a[i] + "]";
        return s;
    }
}
/**
 * Client class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Unused Constructor.
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Mergesort sortedd = new Mergesort();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            sortedd.sort(tokens);
            System.out.println(sortedd.display(tokens));
            System.out.println();
        }
    }
}

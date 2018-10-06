import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for insertion.
 */
class Insertion {
    /**
     * Constructs the object for insertion.
     */
    private Insertion() {
        //empty constructor.
    }
    
    /**
     * { Exchanges the values of i and j in comparable array }.
     *
     * @param      arr   The comparable arr
     * @param      i     the index
     * @param      j     the index
     * The time complexity is constant.
     */
    private static void exchange(final Comparable[] arr,
        final int i, final int j) {
        Comparable swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }
    
    /**
     * compares to comparable objects.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     returns -1 if true otherwise 0.
     * The time complexity is constant.
     */
    private static boolean less(final Comparable i, final Comparable j) {
         return (i.compareTo(j)) < 0;
    }
    
    /**
     * sorts the given array using insertion sort.
     *
     * @param      arr   The comparable arr
     * The time complexity is O(N^2).
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

/**
 * Class for solution.
 */
public class Solution {
    /**
     * main function for solution.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (sc.hasNext()) {
            sb.append(sc.nextLine() + ":");
        }
        String[] lines = sb.toString().split(":");
        Student[] students = new Student[lines.length];
        for (String line : lines) {
            String[] tokens = line.split(",");
            students[i++] = new Student(tokens[0],
            Integer.parseInt(tokens[1]),
            Integer.parseInt(tokens[2]),
            Integer.parseInt(tokens[2 + 1]),
            Integer.parseInt(tokens[2 + 2]),
            Integer.parseInt(tokens[2 + 2 + 1]), (tokens[2 + 2 + 2]),
            (tokens[2 + 2 + 2 + 1]));
        }
        Insertion.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
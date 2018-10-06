import java.util.Scanner;
import java.util.Arrays;
class Insertion {
    private Insertion() {
    }
    private static void exchange(final Comparable[] arr,
        final int i, final int j) {
        Comparable swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }
    private static boolean less(final Comparable i, final Comparable j) {
         return (i.compareTo(j)) < 0;
    }
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

public class Solution {
    public static void main(String[] args) {
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
/**
 * imports scanner package.
 */
import java.util.Scanner;
/**
 * class for Solution.
 * @author Priyanka Maladi.
 */
final class Solution {
    /**
     * Constructs the object for Solution class.
     */
    private Solution() {
        //default constructor.
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        SeparateChainingHashST<String, Integer> obj
        = new SeparateChainingHashST<String, Integer>();
        int num = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < num; i++) {
            String line = sc.nextLine();
            String[] tokens = line.split(",");
            Student student = new Student(tokens[0],
                Integer.parseInt(tokens[1]),
            Double.parseDouble(tokens[2]));
        }
    }
}

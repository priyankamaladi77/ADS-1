/**
 * imports Scanner package.
 */
import java.util.Scanner;
/**
 * class for solution.
 */
public final class Solution {
    /**
     * Constructs the object for class solution.
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
        String[] words = sc.nextLine().split(" ");
        String[] line1 = sc.nextLine().split(" ");
        for (int i = 0; i < line1.length; i++) {
            if (obj.contains(line1[i])) {
                obj.put(line1[i], obj.get(line1[i]) + 1);
            } else {
                obj.put(line1[i], 1);
            }
        }
        String[] line2 = sc.nextLine().split(" ");
        for (int i = 0; i < line2.length; i++) {
            if (obj.contains(line2[i])) {
                if (obj.get(line2[i]) == 0) {
                    System.out.println("No");
                    return;
                } else {
                    obj.put(line2[i], obj.get(line2[i]) - 1);
                }
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}

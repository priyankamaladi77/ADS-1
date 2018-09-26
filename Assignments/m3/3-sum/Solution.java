import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the Object.
     */
    private Solution() {
        //Solution.
    }
    /**
     * Main Method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int[] arr = new int[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        int j = 0;
        int k = 0;
        for (int i = 0; i < len; i++) {
            j = i + 1;
            k = len - 1;
            while (j < k) {
                if (arr[i] + arr[j] + arr[k] < 0) {
                    j += 1;
                } else if (arr[i] + arr[j] + arr[k] > 0) {
                    k -= 1;
                } else {
                    j += 1;
                    k -= 1;
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}

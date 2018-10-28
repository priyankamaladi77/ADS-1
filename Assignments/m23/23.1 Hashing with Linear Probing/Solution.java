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
	 * main method for linear probing hash St.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
        sc.nextLine();
        LinearProbingHashST<String, Integer> hst = new
        LinearProbingHashST<String, Integer>();
        for (int i = 0; i < num; i++) {
            String[] token = sc.nextLine().split(" ");
            switch (token[0]) {
            case "put":
                hst.put(token[1], Integer.parseInt(token[2]));
                break;
            case "get":
                System.out.println(hst.get(token[1]));
                break;
            case "delete":
                hst.delete(token[1]);
                break;
            case "display":
                hst.display();
                break;
            default:
                break;
            }
        }
    }
}

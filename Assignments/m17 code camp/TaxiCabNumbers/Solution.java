/**
 * imports scanner package.
 */
import java.util.Scanner;
/**
 * Class is used to find the nth taxi cab number with m pairs.
 * @author Priyanka Maladi.
 */
public final class Solution {
	/**
	 * default constructor.
	 */
	private Solution() {
		//unused constructor.
	}
	/**
	 * To demonstarte the main solution.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(TaxiCabNumbers.findTaxiCabNumbers(n, m));
	}
}

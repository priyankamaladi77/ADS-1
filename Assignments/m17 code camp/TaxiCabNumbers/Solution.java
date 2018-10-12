import java.util.Scanner;
public final class Solution {
	private Solution() {
		//unused constructor.
	}
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(TaxiCabNumbers.findTaxiCabNumbers(n, m));
	}
}

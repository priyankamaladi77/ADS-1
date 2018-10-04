import java.util.*;
class Problem1 {
public int fact(int n) {
	if (n == 0 || n == 1) {
		return 1;
	}
	return n * fact(n - 1);
}
  public static void main(String[] args) {
  	System.out.println("Enter value of n:");
  	Scanner sc = new Scanner(System.in);
  	int n = sc.nextInt();
  	Problem1 obj = new Problem1();
  	int fact = obj.fact(n); 
  	System.out.println("factorial of " + n +" " + "is" + " " + fact);
  }
}

// // If n = 3
//  fact(3) = 3 * fact(2)
//  				|
//  				2 * fact(1)
//  					|
//  					3 * 2 * 1 = 6
//  The time complexity is O(N).
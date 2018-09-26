import java.util.Scanner;
import java.util.Arrays;
public class Solution {
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int flag = 1;
		int count = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				flag += 1;
			} else {
				count += (flag * (flag - 1)) / 2;
				flag = 1;
			}
		}
		count += (flag * (flag - 1)) / 2;
		System.out.println(count);
	}
}

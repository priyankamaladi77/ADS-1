import java.util.*;
public class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		while (sc.hasNext()) {
			Comparable[] tokens = sc.nextLine().split(" ");
            sort(tokens);
        }
	}
	private static void exchange(Comparable[] arr, int i, int min) {
		Comparable swap = arr[i];
		arr[i] = arr[min];
		arr[min] = swap;
	}
	private static boolean less(Comparable arr1, Comparable arr2) {
		 return (arr1.compareTo(arr2)) < 0;
	}
	public static void sort(Comparable[] arr) {
		int num = arr.length;
		for (int i = 0; i < num; i++) {
			int min = i;
			for (int j = i + 1; j < num; j++) {
				if (less(arr[j], arr[min])) {
					min = j;
				}
			}
			exchange(arr, i, min);
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}
}

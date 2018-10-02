import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int i = 0;
		while (sc.hasNext()) {
			sb.append(sc.nextLine() + "#");
		}
		String[] lines = sb.toString().split("#");
		Team[] teams = new Team[lines.length];
		for (String line : lines) {
			String[] tokens = line.split(",");
			teams[i++] = new Team(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
		}
		Selection.sort(teams);
		String result = Arrays.toString(teams);
		result = result.replace("[", "").replace("]", "").replace(", ", ",");
		System.out.println(result);
	}
}

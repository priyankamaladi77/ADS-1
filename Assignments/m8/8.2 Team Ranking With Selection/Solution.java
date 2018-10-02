import java.util.Scanner;
import java.util.Arrays;
class Team implements Comparable<Team> {
	private String teamname;
	private int wins;
	private int losses;
	private int draws;

	Team(String name, int win, int lose, int draw) {
		this.teamname = name;
		this.wins = win;
		this.losses = lose;
		this.draws = draw;
	}
	public String getName() {
		return this.teamname;
	}
	public int getWins() {
		return this.wins;
	}
	public int getLosses() {
		return this.losses;
	}
	public int getDraws() {
		return this.draws;
	}
	public void setName(String nam) {
		this.teamname = nam;
	}
	public void setWins(int won) {
		this.wins = won;
	}
	public void setLosses(int loss) {
		this.losses = loss;
	}
	public void setDraws(int draw) {
		this.draws = draw;
	}
	public String toString() {
		return this.teamname;
	}
	public int compareTo(Team that) {
		if (this.wins > that.wins) return -1;
		if (this.wins < that.wins) return +1;
		if (this.losses < that.losses) return -1;
		if (this.losses > that.losses) return +1;
		if (this.draws > that.draws) return -1;
		if (this.draws < that.draws) return +1;
		return 0;
	}
}
class Selection {
	Selection() {
	}
	private static void exchange(Comparable[] arr, int i, int min) {
		Comparable swap = arr[i];
		arr[i] = arr[min];
		arr[min] = swap;
	}
	private static boolean less(Comparable v, Comparable w) {
		 return (v.compareTo(w)) < 0;
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
	}
}
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

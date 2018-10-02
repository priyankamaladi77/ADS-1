/**
 * { imports Scanner package }
 */
import java.util.Scanner;
/**
 * { imports Arrays package }
 */
import java.util.Arrays;

/**
 * Class for solution.
 * @author     priyanka maladi.
 */
public final class Solution {
    /**
     * Constructs the object for Solution.
     */
    private Solution() {
        //empty constructor.
    }
    /**
     * main method for Team Ranking with insertion sort.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
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
            teams[i++] = new Team(tokens[0],
                Integer.parseInt(tokens[1]),
                Integer.parseInt(tokens[2]),
                Integer.parseInt(tokens[2 + 1]));
        }
        Insertion.sort(teams);
        String result = Arrays.toString(teams);
        result = result.replace("[", "").replace("]", "").replace(", ", ",");
        System.out.println(result);
    }
}

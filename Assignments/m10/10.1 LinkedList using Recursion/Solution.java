import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //empty constructor.
    }
    /**
     * client program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Linkedlist link = new Linkedlist();
        while (sc.hasNext()) {
            String[] tokens = sc.nextLine().split(" ");
            switch (tokens[0]) {
            case "insertAt":
                if (Integer.parseInt(tokens[1]) < 0 || Integer.parseInt(
                            tokens[1]) > link.size() + 1) {
                    System.out.println("Can't insert at this position.");
                } else {
                    link.insertAt(Integer.parseInt(tokens[1]),
                                   Integer.parseInt(tokens[2]));
                    System.out.println(link.toString());
                }
                break;
            case "reverse":
                if (!link.isEmpty()) {
                    link.reverse();
                    System.out.println(link.toString());
                } else {
                    System.out.println("No elements to reverse.");
                    break;
                }
            default:
                break;
            }
        }

    }
}

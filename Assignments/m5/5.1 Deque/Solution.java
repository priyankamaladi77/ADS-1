import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty.
    }
    /**
     * Main method to implement Deque.
     *
     * @param args The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        Deque deque = new Deque();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
            case "size":
                int count = deque.getSize();
                System.out.println(count);
                break;
            case "pushLeft":
                deque.pushLeft(Integer.parseInt(tokens[1]));
                System.out.println(deque);
                break;
            case "pushRight":
                deque.pushRight(Integer.parseInt(tokens[1]));
                System.out.println(deque);
                break;
            case "popLeft":
                if (!(deque.isEmpty())) {
                    deque.popLeft();
                    System.out.println(deque);
                } else {
                    System.out.println("Deck is empty");
                }
                break;
            case "popRight":
                if (!(deque.isEmpty())) {
                    deque.popRight();
                    System.out.println(deque);
                } else {
                    System.out.println("Deck is empty");
                }
                break;
            default:
                break;
            }
        }
    }
}

/**
 * { imports Scanner package }.
 */
import java.util.Scanner;

/**
 * class for Solution.
 */
public final class Solution {
    /**
     * Constructs the object for class Solution.
     */
    private Solution() {
        // unused constructor.
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        while (sc.hasNext()) {
            String[] token = sc.nextLine().split(",");
            switch (token[0]) {
                case "put":
                Book book = new Book(token[1], token[2],
                    Double.parseDouble(token[2 + 1]));
                bst.put(book, token[2 + 2]);
                break;
                case "get":
                book = new Book(token[1], token[2],
                    Double.parseDouble(token[2 + 1]));
                System.out.println(bst.get(book));
                break;
                default:
                break;
            }
        }
    }
}

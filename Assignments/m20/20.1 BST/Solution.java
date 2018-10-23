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
      //default constructor.
    }
    /**
     * main method.
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
                Book books = new Book(token[1],
                token[2], Float.parseFloat(token[2 + 1]));
                bst.put(books, Integer.parseInt(token[2 + 2]));
                break;
            case "get":
                books = new Book(token[1], token[2],
                Float.parseFloat(token[2 + 1]));
                if (bst.get(books) == -1) {
                    System.out.println("null");
                } else {
                    System.out.println(bst.get(books));
                }
                break;
            case "max":
                System.out.println(bst.max());
                break;
            case "min":
                System.out.println(bst.min());
                break;
            case "floor":
                books = new Book(token[1],
                token[2], Float.parseFloat(token[2 + 1]));
                System.out.println(bst.floor(books));
                break;
            case "ceiling":
                books = new Book(token[1],
                token[2], Float.parseFloat(token[2 + 1]));
                System.out.println(bst.ceiling(books));
                break;
            case "select":
                System.out.println(bst.select(
                    Integer.parseInt(token[1])));
                break;
            case "deleteMax":
                bst.delMax();
            break;
            case "deleteMin":
                bst.delMin();
            break;
            case "delete":
                books = new Book(token[1], token[2],
                        Float.parseFloat(token[2 + 1]));
                bst.del(books);
            break;
            default:
            break;
            }
        }
    }
}

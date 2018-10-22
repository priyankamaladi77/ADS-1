import java.util.Scanner;
/**
 * solution class.
 */
public final class Solution {
    /**
     * Constructs the booksect.
     */
    private Solution() {
      
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
                System.out.println(bst.Max());
                break;
            case "min":
                System.out.println(bst.Min());
                break;
            case "floor":
                books = new Book(token[1],
                token[2], Float.parseFloat(token[2 + 1]));
                System.out.println(bst.Floor(books));
                break;
            case "ceiling":
                books = new Book(token[1],
                token[2], Float.parseFloat(token[2 + 1]));
                System.out.println(bst.Ceiling(books));
                break;
            case "select":
                System.out.println(bst.Select
                    (Integer.parseInt(token[1])));
                break;
            default:
                break;
            }
        }
    }
}

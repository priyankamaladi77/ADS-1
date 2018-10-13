import java.util.NoSuchElementException;
/**
 * { importing scanner package }.
 */
import java.util.Scanner;
/**
 * class for Solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused constructor.
    }
    /**
     * client program for Binary search Symbol table.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        SymbolTable<String, Integer> st = new
        SymbolTable<String, Integer>();
        String[] tokens = sc.nextLine().split(" ");
        for (int i = 0; i < tokens.length; i++) {
            st.put(tokens[i], i);
        }
        while (sc.hasNext()) {
            String[] check = sc.nextLine().split(" ");
            switch (check[0]) {
                case "max":
                    System.out.println(st.max());
                    break;
                case "floor":
                    System.out.println(st.floor(check[1]));
                    break;
                case "rank":
                    System.out.println(st.rank(check[1]));
                    break;
                case "deleteMin":
                    st.delMin();
                    break;
                case "contains":
                    System.out.println(st.contains(tokens[1]));
                    break;
                case "keys":
                    System.out.println(st);
                    break;
                case "get":
                    System.out.println(st.get(check[1]));
                    break;
                default:
                    break;
            }
        }
    }
}

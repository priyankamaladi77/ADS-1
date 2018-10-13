import java.util.Scanner;
/**
 * Linked Lists.
 */
class LinkedList {
    /**
     * Node variable.
     */
    private Node first;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * character for item.
         */
        private char item;
        /**
         * Node object for next.
         */
        private Node next;
    }
    /**
     * Constructs the object.
     */
    LinkedList() {
        this.first = null;
    }
    /**
     * Determines if empty.
     *
     * @return  returns true if empty, False otherwise.
     */
    public boolean isEmpty() {
        return (first == null);
    }
    /**
     * method to pop the element.
     *
     * @return returns the pop element on the top.
     *
     * @throws Exception if stack is empty.
     */
    public char pop() throws Exception {
        if (!isEmpty()) {
            if (first != null) {
                char val = first.item;
                first = first.next;
                return val;
            } else {
                throw new Exception("Stack is Empty");
            }
        }
        return '\0';
    }
    /**
     * to push the element.
     *
     * @param      val  The val
     */
    public void push(final char val) {
        Node oldfirst = first;
        first = new Node();
        first.item = val;
        first.next = oldfirst;
    }
}
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
     * Main method for paranthesis is balanced or not.
     *
     * @param args The arguments.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        int j = 0;
        while (j < num) {
            boolean val = check(sc);
            if (val) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            j++;
        }
    }
    /**
     *
     * @param      scan  The scan.
     *
     * @return returns true if list1 is empty or false otherwise.
     */
public static boolean check(final Scanner scan) {
        LinkedList list1 = new LinkedList();
        String str = scan.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                list1.push(ch);
            } else if (list1.isEmpty()) {
                return false;
            } else if (ch == ')') {
                try {
                    if (list1 == null || list1.pop() != '(') {
                        return false;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (ch == ']') {
                try {
                    if (list1 == null || list1.pop() != '[') {
                        return false;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (ch == '}') {
                try {
                    if (list1 == null || list1.pop() != '{') {
                        return false;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return (list1.isEmpty());
    }
}

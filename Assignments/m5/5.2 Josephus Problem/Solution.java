import java.util.Scanner;
/**
 * Class for deque.
 */
class Deque {
    /**
     * {Variable head of type node}.
     */
    private Node head;
    /**
     * {Variable tail of type node}.
     */
    private Node tail;
    /**
     * {Variable size of type integer}.
     */
    private int size;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * {Variable name of type int}.
         */
        private int name;
        /**
         * {Variable next of type node}.
         */
        private Node next;
    }
    /**
     * Constructs the object.
     */
    Deque() {
        head = null;
        tail = null;
        size = 0;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return (head == null);
    }
    /**
     * {Method to pop an element from the front}.
     *
     * @return     {Integer}
     */
    public int popLeft() {
        if (head != null) {
            int item = head.name;
            head = head.next;
            return item;
        }
        return tail.name;
    }
    /**
     * Method to push back an element.
     *
     * @param      name  The name
     */
    public void pushRight(final int name) {
        if (tail == null) {
            tail = new Node();
            tail.name = name;
            tail.next = null;
            head = tail;
        } else {
            Node temp = tail;
            tail = new Node();
            tail.name = name;
            tail.next = null;
            temp.next = tail;
        }
    }
    /**
     * {Method to get size}.
     *
     * @return     {Integer}
     */
    public int getsize() {
        return size;
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
     * {Main method}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            int count = Integer.parseInt(tokens[0]);
            int rounds = Integer.parseInt(tokens[1]);
            String str = "";
            Deque deque = new Deque();
            for (int i = 0; i < count; i++) {
                deque.pushRight(i);
            }
            while (!deque.isEmpty()) {
                for (int i = 0; i < rounds - 1; i++) {
                    deque.pushRight(deque.popLeft());
                }
                str += deque.popLeft() + " ";
            }
            System.out.print(str.substring(0, str.length() - 1));
            System.out.println();
        }
    }
}

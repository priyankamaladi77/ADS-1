import java.util.Scanner;
/**
 * List of linkeds.
 */
class Linkedlist {
    /**
     * description of variable head.
     */
    private Node head;
    /**
     * description of variable size.
     */
    private int size;
    /**
     * Constructs the object for Linkedlist.
     */
    Linkedlist() {
        this.head = null;
        this.size = 0;
    }
    /**
     * size of list.
     *
     * @return returns size.
     */
    public int size() {
        return size;
    }
    /**
     * Determines if empty.
     *
     * @return     returns true if empty, False otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }
    /**
     * insert at position.
     *
     * @param      position  The position
     * @param      val     The value 1
     */
    public void insertAt(final int position, final int val) {
        insertAt(head, position, val);
    }
    /**
     * inserts at a position.
     *
     * @param      node      The node
     * @param      position  The position
     * @param      val       The value
     */
    private void insertAt(final Node node,
                          final int position, final int val) {
        if (position == 0 && head == null) {
            head = new Node(val);
        } else if (position == 0 && head != null) {
            Node oldhead = head;
            head = new Node(val);
            head.setNextlink(oldhead);
        } else {
            Node temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.getNextlink();
            }
            Node nextNode = temp.getNextlink();
            Node node1 = new Node(val);
            temp.setNextlink(node1);
            node1.setNextlink(nextNode);
        }
        size++;
    }
    /**
     * reverses the head.
     */
    public void reverse() {
        head = reverse(head);
    }
    /**
     *reverse of list.
     *
     * @param      h1  The head
     *
     * @return  returns the node.
     */
    private Node reverse(final Node h1) {
        if (h1 == null || h1.getNextlink() == null) {
            return h1;
        }
        Node temp = reverse(h1.getNextlink());
        h1.getNextlink().setNextlink(h1);
        h1.setNextlink(null);
        return temp;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        if (size != 0) {
            Node temp = head;
            while (temp != null) {
                str += temp.getData() + ", ";
                temp = temp.getNextlink();
            }
        }
        return str.substring(0, str.length() - 2);
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

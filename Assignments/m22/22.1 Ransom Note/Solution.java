import java.util.Iterator;
/**
 * imports Scanner package.
 */
import java.util.Scanner;
/**
 * class for solution.
 */
public final class Solution {
    /**
     * Constructs the object for class solution.
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
        SeparateChainingHashST<String, Integer> obj
        = new SeparateChainingHashST<String, Integer>();
        String[] words = sc.nextLine().split(" ");
        String[] line1 = sc.nextLine().split(" ");
        for (int i = 0; i < line1.length; i++) {
            if (obj.contains(line1[i])) {
                obj.put(line1[i], obj.get(line1[i]) + 1);
            } else {
                obj.put(line1[i], 1);
            }
        }
        String[] line2 = sc.nextLine().split(" ");
        for (int i = 0; i < line2.length; i++) {
            if (obj.contains(line2[i])) {
                if (obj.get(line2[i]) == 0) {
                    System.out.println("No");
                    return;
                } else {
                    obj.put(line2[i], obj.get(line2[i]) - 1);
                }
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
class Queue<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }
    /**
     * Initializes an empty queue.
     */
    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }
    /**
     * Returns true if this queue is empty.
     *
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
    public int size() {
        return n;
    }

    /**
     * Returns the item least recently added to this queue.
     *
     * @return     the item least recently added to this queue
     */
    public Item peek() {
        return first.item;
    }

    /**
     * Adds the item to this queue.
     *
     * @param  item the item to add
     */
    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     *
     * @return     the item on this queue that was least recently added
     */
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     *
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}

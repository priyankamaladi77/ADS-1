import java.util.*;
class Node {
    private int val;
    private Node nextlink;

    Node(int value) {
        this.val = value;
        this.nextlink = null;
    }

    public int getVal() {
        return this.val;
    }

    public Node getNextLink() {
        return this.nextlink;
    }

    public void setVal(int valu) {
        this.val = valu;
    }

    public void setNextLink(Node link) {
        this.nextlink = link;
    }
}
class LinkedList {
    private Node start;
    private int size;

    LinkedList(int size) {
        this.size = 0;
        this.start = null;
    }
    LinkedList() {
        this.size = 0;
        this.start = null;
    }


    public void pushRight(int val) {
        if (start == null) {
            Node newnode = new Node(val);
            start = newnode;
        } else {
            Node nextnode = new Node(val);
            Node temp = start;
            while (temp.getNextLink() != null) {
                temp = temp.getNextLink();
            }
            temp.setNextLink(nextnode);
        }
        size++;
    }

    public void pushLeft(int val) {
        Node enode = new Node(val);
        enode.setNextLink(start);
        start = enode;
        size ++;
    }

    public void removeLeft() {
        if (start == null) {
            start = start.getNextLink();
            size--;
        } else {
            System.out.println("No nodes to remove");
        }
        
    }

    public void removeRight() {
        if (start == null) {
            System.out.println("Node is Empty");
        } else if (size < 2) {
            start = null;
        } else {
            Node temp = start;
            while (temp.getNextLink().getNextLink() != null) {
                temp = temp.getNextLink();
            }
            temp.setNextLink(null);
        }
        size--;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String str = "";
        Node temp = start;
        if (temp == null) {
            return "Empty linked list";
        }
        while (temp.getNextLink() != null) {
            str += temp.getVal() + ", ";
            temp = temp.getNextLink();
        } str += temp.getVal();
        return str;
    }
}


public class Solution {
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        while(scan.hasNext()) {
            String[] line = scan.nextLine().split(" ");
            switch(line[0]) {
                case "size":
                System.out.println(ll.size());
                break;
                case "pushLeft":
                ll.pushLeft(Integer.parseInt(line[1]));
                System.out.println(ll);
                break;
                case "pushRight":
                ll.pushRight(Integer.parseInt(line[1]));
                System.out.println(ll);
                break;
                case "removeLeft":
                ll.removeLeft();
                System.out.println(ll);
                break;
                case "removeRight":
                ll.removeRight();
                System.out.println(ll);
                break;
                default:
                break;
            }
        }
    }
}

import java.util.NoSuchElementException;
import java.util.Scanner;
class Book implements Comparable<Book> {
	private String bookname;
	private String authorname;
	private double price;

	Book(String name, String author, double cost) {
		this.bookname = name;
		this.authorname = author;
		this.price = cost;
	}
	public String getBookname() {
		return this.bookname;
	}
	public String getAuthorname() {
		return this.authorname;
	}
	public double getPrice() {
		return this.price;
	}
	public int compareTo(Book that) {
		return this.getBookname().compareTo(that.getBookname());
	}
}
class BinarySearchTree<Key extends Comparable<Key>, Value> {
	private Node root;
	private class Node {
		private Book key;
		private String val;
		private Node left;
		private Node right;

		Node(Book keys, String value) {
		this.key = keys;
		this.val = value;
		}
	}
	BinarySearchTree() {
		root = null;
	}
	public void put(final Book key, final String val) {
		Node a = new Node(key, val);
		if (root == null) {
			root = a;
			return;
		}
		Node p = null;
		Node b = root;
		while (b != null) {
			p = b;
			int cmp = key.getBookname().compareTo(b.key.getBookname());
			if (cmp < 0) {
				b = b.left;
			} else if (cmp > 0) {
				b = b.right;
			} else {
				b.val = val;
				return;
			}
		}
		int cmp = key.compareTo(p.key);
		if (cmp < 0) {
			p.left = a;
		} else {
			p.right = a;
		}
	}
	public String get(final Book key) {
		Node b = root;
		while (b != null) {
			int cmp = key.getBookname().compareTo(b.key.getBookname());
			if (cmp < 0) {
				b = b.left;
			} else if (cmp > 0) {
				b = b.right;
			} else {
				return b.val;
			}
		}
		return null;
	}
}
public final class Solution {
	private Solution() {
		// unused constructor.
	}
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		while (sc.hasNext()) {
			String[] token = sc.nextLine().split(",");
			switch (token[0]) {
				case "put":
				Book book = new Book(token[1], token[2], Double.parseDouble(token[2 + 1]));
				bst.put(book, token[2 + 2]);
				break;
				case "get":
				book = new Book(token[1], token[2], Double.parseDouble(token[2 + 1]));
				System.out.println(bst.get(book));
				break;
				default:
				break;
			}
		}
	}
}

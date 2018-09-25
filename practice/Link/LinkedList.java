class LinkedList {
	private Node start;
	private int size;

	LinkedList(int size) {
		this.size = 0;
		this.start = null;
	}

	public void addEnd(int val) {
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
	}

	public void PushLeft(int val) {
		Node enode = new Node(val);
		enode.setNextLink(start);
		start = enode;
	}

	public void RemoveLeft() {
		if (start == null) {
			start = start.getNextLink();
		}
		size--;
	}

	public void RemoveRight() {
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
	public int Size() {
		return size;
	}

	public String toString() {
		String str = "";
		Node temp = start;
		while (temp != null) {
			str += temp.getVal() + ", ";
		}
		return(str);
	}
}

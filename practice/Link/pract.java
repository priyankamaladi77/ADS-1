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
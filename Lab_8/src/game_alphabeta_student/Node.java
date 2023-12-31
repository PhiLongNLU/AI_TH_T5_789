package game_alphabeta_student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Node {
	private String label;
	private int value;
	private List<Node> children = new ArrayList<Node>();
	private Node parent;

	// use for non-terminal node
	public Node(String label) {
		super();
		this.label = label;
	}

	// use for terminal node
	public Node(String label, int value) {
		super();
		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public List<Node> getChildren() {
		return children;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public static void printPath(Node node) {
		if(node.getParent() == null) {
			System.out.print(node + " ");
			return;
		}
		else {
			System.out.print(node + " ");
			printPath(node.getParent());
		}
	}
	private Node getParent() {
		// TODO Auto-generated method stub
		return this.parent;
	}

	// add a child to this node
	public void addChild(Node that) {
		this.children.add(that);
	}
	
	public Node max (Node o) {
		if(this.getValue() > o.getValue()) return this;
		else if(this.getValue() < o.value) return o;
		else return this;
	}

	// check whether this node is terminal or not. The terminal node is assigned a
	// value.
	public boolean isTerminal() {
		return this.children.size() == 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Node))
			return false;
		Node that = (Node) obj;
		return this.getLabel().equals(that.getLabel());
	}

	@Override
	public String toString() {
		return this.label;
	}

	// Defined comparator which is used for sorting children by alphabetical order
	public static Comparator<Node> LabelComparator = new Comparator<Node>() {
		@Override
		public int compare(Node o1, Node o2) {
			return o1.getLabel().compareTo(o2.getLabel());
		}
	};
	
	// Defined comparator which is used for sorting children by alphabetical order
		public static Comparator<Node> LabelComparatorReverse = new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return -o1.getLabel().compareTo(o2.getLabel());
			}
		};

		public Node min(Node o) {
			// TODO Auto-generated method stub
			if(this.getValue() < o.getValue()) return this;
			else if(this.getValue() > o.value) return o;
			else return this;
		}
}

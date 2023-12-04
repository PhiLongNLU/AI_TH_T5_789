package game_nim_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
	private Node parent;
	private List<Integer> data = new ArrayList<Integer>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
		// Enter your code here
		List<Node> children = new ArrayList<Node>();
		for (int i = 0; i < data.size(); i++) {
			int number = data.get(i);
			for (int j = 1; j <= number / 2; j++) {
				Node node = new Node();
				if (j != (number / 2) + (number % 2)) {
					node.add(j);
					node.add(number - j);
					for (int k = 1; k < data.size(); k++) {
						node.add(data.get(k));
					}
					children.add(node);
				}

			}
		}
		return children;

	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		// Enter your code here
		data.sort(DESCOMPARATOR);
		return data.get(0) <= 2 ? true : false;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}



	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

}

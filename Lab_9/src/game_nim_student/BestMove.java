package game_nim_student;

import java.util.List;

public class BestMove {
	public void execute(Node node) {
		Node v = minValue(node);
		System.out.println(v);
	}

	public Node maxValue(Node node) {
		if (node.isTerminal())
			return node;
		else {
			Node maxNode = null;
			List<Node> childs = node.getSuccessors();
			for (int i = 0; i < childs.size(); i++) {
				childs.get(i).setParent(node);
				if (maxNode == null) {
					maxNode = minValue(childs.get(i));
				}
			}
			return maxNode;
		}
	}

	public Node minValue(Node node) {
		if (node.isTerminal())
			return node;
		else {
			Node minNode = null;
			List<Node> childs = node.getSuccessors();
			for (int i = 0; i < childs.size(); i++) {
				childs.get(i).setParent(node);
				if (minNode == null) {
					minNode = maxValue(childs.get(i));
				}
			}
			return minNode;
		}
	}
}

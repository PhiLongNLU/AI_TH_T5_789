package game_alphabeta_student;

import java.util.List;

public class FindBestWay  {
	
	public Node execute(Node node) {
		// Enter your code here
		return maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	
	public Node maxValue(Node node, int alpha, int beta) {
		// Enter your code here

		if (node.isTerminal())
			return node;

		int maxVal = Integer.MIN_VALUE;
		List<Node> child = node.getChildren();
		Node maxNode = null;

		child.sort(Node.LabelComparator);

		for (int i = 0; i < child.size(); i++) {
			child.get(i).setParent(node);
			if(maxNode == null) {
				maxNode = minValue(child.get(i), alpha, beta);
			}
			maxNode = maxNode.max(minValue(child.get(i), alpha, beta));
			if (maxVal >= beta)
				return maxNode;
			alpha = Math.max(alpha, maxVal);
		}
		return maxNode;
	}
	
	public Node minValue(Node node, int alpha, int beta) {
		// Enter your code here

		if (node.isTerminal())
			return node;

		int minVal = Integer.MAX_VALUE;
		List<Node> child = node.getChildren();
		Node minNode = null;

		child.sort(Node.LabelComparator);

		for (int i = 0; i < child.size(); i++) {
			child.get(i).setParent(node);
			if(minNode == null) {
				minNode = minValue(child.get(i), alpha, beta);
			}
			minNode = minNode.min(maxValue(child.get(i), alpha, beta));
			if (minVal <= alpha)
				return minNode;
			beta = Math.min(alpha, minVal);
		}
		return minNode;
	}

	public static void main(String[] args) {
		Node root = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D", 0);
		Node e = new Node("E");
		Node f = new Node("F");
		Node g = new Node("G", -5);
		Node h = new Node("H", 3);
		Node i = new Node("I", 8);
		Node j = new Node("J");
		Node k = new Node("K");
		Node l = new Node("L", 2);
		Node m = new Node("M");
		Node n = new Node("N", 4);
		Node o = new Node("O");
		Node p = new Node("P", 9);
		Node q = new Node("Q", -6);
		Node r = new Node("R", 0);
		Node s = new Node("S", 3);
		Node t = new Node("T", 5);
		Node u = new Node("U", -7);
		Node v = new Node("V", -9);
		Node w = new Node("W", -3);
		Node x = new Node("X", -5);

		root.addChild(b);
		root.addChild(c);
		root.addChild(d);
		root.addChild(e);
		b.addChild(f);
		b.addChild(g);
		c.addChild(h);
		c.addChild(i);
		c.addChild(j);
		e.addChild(k);
		e.addChild(l);
		e.addChild(m);
		f.addChild(n);
		f.addChild(o);
		j.addChild(p);
		j.addChild(q);
		j.addChild(r);
		k.addChild(s);
		k.addChild(t);
		m.addChild(u);
		m.addChild(v);
		o.addChild(w);
		o.addChild(x);
		
		FindBestWay find = new FindBestWay();
		Node result = find.execute(root);
		Node.printPath(result);
	}
}

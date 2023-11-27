package game_alphabeta_student;

import java.util.List;

public class FindBestWay  {
	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	public Node execute(Node node) {
		// Enter your code here
		return maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

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
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public Node minValue(Node node, int alpha, int beta) {
		// Enter your code here

		if (node.isTerminal())
			return node;

		int maxVal = Integer.MAX_VALUE;
		List<Node> child = node.getChildren();
		Node maxNode = null;

		child.sort(Node.LabelComparator);

		for (int i = 0; i < child.size(); i++) {
			child.get(i).setParent(node);
			if(maxNode == null) {
				maxNode = minValue(child.get(i), alpha, beta);
			}
			maxNode = maxNode.max(minValue(child.get(i), alpha, beta));
			if (maxVal <= beta)
				return maxNode;
			alpha = Math.min(alpha, maxVal);
		}
		return maxNode;
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

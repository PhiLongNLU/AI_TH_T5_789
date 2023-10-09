package Task3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal)) {
				return current;
			}
			List<Node> list = current.getChildrenNodes();
			for (int i = 0; i < list.size(); i++) {
				Node node = list.get(i);
				node.setParent(current);
				if (node.getLabel().equals(goal)) {
					return node;
				}
				frontier.add(node);
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);
		boolean flag = false;
		FindChild :
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			List<Node> listChild = current.getChildrenNodes();
				for(int i = 0 ; i < listChild.size() ; i++) {
				Node child = listChild.get(i);
				if(child.getLabel().equals(start)) {
					frontier.clear();
					frontier.add(child);
					flag = true;
					continue FindChild;
				}
				child.setParent(current);
				if(child.getLabel().equals(goal) && flag) {
					return child;
				}
				frontier.add(child);
				
			}
		}
		return null;

	}

}

package Task4_5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class UniformCostSearchAlgo implements ISearchAlgo{
	
	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		List<Node> explorer = new ArrayList<>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			explorer.add(current);
			if (current.getLabel().equals(goal)) {
				return current;
			}

			List<Edge> list = current.getChildren();
				for (int i = 0; i < list.size(); i++) {
					Edge nodeEdge = list.get(i);
					Node newNode = new Node(nodeEdge.getEnd());
					newNode.setParent(current);
					newNode.setPathCost(nodeEdge.getWeight() + current.getPathCost());
					for (Node nodeInFrontier : frontier) {
						if (nodeInFrontier.getLabel().equals(newNode.getLabel())
								&& nodeInFrontier.getPathCost() > newNode.getPathCost()) {
							frontier.remove(nodeInFrontier);
							frontier.add(newNode);
							break;						}
					}
					if (!explorer.contains(newNode) && !frontier.contains(newNode)) {
						frontier.add(newNode);
					}
			}
			System.out.println(frontier);

		}

		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		List<Node> explorer = new ArrayList<>();
		frontier.add(root);
		
		Find : 
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			explorer.add(current);
			if (current.getLabel().equals(goal)) {
				return current;
			}
			

			List<Edge> list = current.getChildren();
				for (int i = 0; i < list.size(); i++) {
					Edge nodeEdge = list.get(i);
					Node newNode = new Node(nodeEdge.getEnd());
					if(newNode.getLabel().equals(start)) {
						frontier.clear();
						frontier.add(newNode);
						continue Find;
					}
					newNode.setParent(current);
					newNode.setPathCost(nodeEdge.getWeight() + current.getPathCost());
					for (Node nodeInFrontier : frontier) {
						if (nodeInFrontier.getLabel().equals(newNode.getLabel())
								&& nodeInFrontier.getPathCost() > newNode.getPathCost()) {
							frontier.remove(nodeInFrontier);
							frontier.add(newNode);
							break;						}
					}
					if (!explorer.contains(newNode) && !frontier.contains(newNode)) {
						frontier.add(newNode);
					}
			}
			System.out.println(frontier);

		}
		
		return null;
	}

}

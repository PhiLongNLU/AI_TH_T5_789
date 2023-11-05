package Task_1;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStarAlgo implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) {
		
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		List<Node> explored = new ArrayList<Node>();
		
		Node start = new Node(model.getInitialState());
		start.setH(model.computeH1(start));
		frontier.add(start);
		
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			explored.add(current);
			if(current.getH() == 0) return current;
			else {
				for(Node childNode : model.getSuccessors(current)) {
					if(!frontier.contains(childNode) && !explored.contains(childNode)) {
						childNode.setG(current.getG() + childNode.getH() - current.getH() + 1);
						frontier.add(childNode);
					}
					
					else if(frontier.contains(childNode) && !explored.contains(childNode)) {
						for(Node node : frontier) {
							if(	current.equals(node) &&	current.getF() < node.getF()) {
								frontier.remove(node);
								frontier.add(childNode);
								break;
							}
						}
					}
				}
				
				
			}
			
		}
		return null;
	}

}

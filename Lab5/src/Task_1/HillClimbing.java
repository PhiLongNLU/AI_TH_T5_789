package Task_1;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class HillClimbing implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) {
		
		List<Node> explored = new ArrayList<Node>();
		Node current = new Node(model.getInitialState());
		current.setH(model.computeH2(current));
		
	    while (true) { 
	// save the node has been traverses
	    	explored.add(current);
	    	
	    	if(current.getH() == 0) return current;
	    	PriorityQueue<Node> neighbors = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByF);
	    	
	// Add neighbor of current to neighbors and sort by H1
	    	for(Node children : model.getSuccessors(current)) {
	    		children.setG(current.getG() + children.getH() - current.getH() + 1);
	    		neighbors.add(children);
	    	}
	    	
	// take the best choice from neighbor and check whether or not the node more performance than current node
	    	Node tmp = neighbors.poll();
	    	if(current.getF() >= tmp.getF()) {
	    		current = tmp;
	    	}
	    	else return current;
	    }
	}

}

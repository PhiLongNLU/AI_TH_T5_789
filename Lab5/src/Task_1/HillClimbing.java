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
	    	if(current.getH() == 0) return current;
	    	explored.add(current);
	    	
	    	PriorityQueue<Node> neighbors = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
	    	
	// Add neighbor of current to neighbors and sort by H1
	    	for(Node children : model.getSuccessors(current)) {
	    		if(!explored.contains(children)) {
		    		neighbors.add(children);
	    		}
	    	}
	    	
	// take the best choice from neighbor and check whether or not the node more performance than current node
	    	Node tmp = neighbors.poll();
	    	if(current.getH() > tmp.getH()) {
	    		current = tmp ;
	    		
	    	}
	    	else {
	    		break;
	    	}
	    	
	    }
	    return current;
	}

}

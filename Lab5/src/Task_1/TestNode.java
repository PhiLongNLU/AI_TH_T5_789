package Task_1;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class TestNode {

	public static void main(String[] args) {
		Puzzle p = new Puzzle();
		p.readInput("txt/PuzzleMap.txt", "txt/PuzzleGoalState.txt");

//		Node initialState = p.getInitialState();
//		Node tmp = new Node(initialState);
//		System.out.println(initialState.equals(tmp));
//		Node goalState = p.getGoalState();
//		System.out.println(p.getInitialState());
//		System.out.println("H: "+initialState.getH());
//		System.out.println(Arrays.toString(initialState.getWhiteTilePosition()));
//		System.out.println(p.getGoalState());
//		Node re = p.moveWhiteTile(initialState, 'r');
//
//		System.out.println(re);
//		System.out.println(re.getH());
//		System.out.println(initialState);
//		System.out.println(Arrays.toString(re.getWhiteTilePosition()));
//		System.out.println(p.computeH(init, goal));

		// System.out.println(p.getInitialState());
		// System.out.println(p.getGoalState());
		//
		// List<Node> children = p.getSuccessors(initialState);
		// System.out.println("Size: "+children.size());
		// for (Node child : children) {
		// System.out.println(child.getH()+" "+p.computeH(child) );
		// }
		
		long begin = Calendar.getInstance().getTimeInMillis();
		
///Use greedy best first search algorithm :
//		IPuzzleAlgo greedy = new GreedyBFS();
//		Node result = greedy.execute(p);
//		System.out.println(result);
		
///Use A* algorithm :
//		IPuzzleAlgo aStar = new AStarAlgo();
//		Node result = aStar.execute(p);
//		System.out.println(result);

///user Hill Climbing algorithm :
		IPuzzleAlgo hillClimbing = new HillClimbing();
		Node result = hillClimbing.execute(p);
		System.out.println(result);
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.println("Executed Time: " + (end - begin));

	}
}

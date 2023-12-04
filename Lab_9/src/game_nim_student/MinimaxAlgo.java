package game_nim_student;

import java.util.List;

public class MinimaxAlgo {
	public void execute(Node node) {
		int v = minValue(node);
		System.out.println(v);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		if(node.isTerminal()) return 1;
		else {
			int maxVal = Integer.MIN_VALUE;
			List<Node> childs =  node.getSuccessors();
			for(int i = 0 ; i < childs.size() ; i++) {
				maxVal = Math.max(maxVal, minValue(childs.get(i)));
			}
			return maxVal;
		}
	}

	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v
	public int minValue(Node node) {
		if(node.isTerminal()) return 0;
		else {
			int minVal = Integer.MAX_VALUE;
			List<Node> childs =  node.getSuccessors();
			for(int i = 0 ; i < childs.size() ; i++) {
				minVal = Math.min(minVal, maxValue(childs.get(i)));
			}
			return minVal;
		}
	}
}

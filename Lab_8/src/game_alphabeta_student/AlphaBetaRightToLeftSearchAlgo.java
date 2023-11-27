package game_alphabeta_student;

import java.util.List;

public class AlphaBetaRightToLeftSearchAlgo implements ISearchAlgo{

	// function ALPHA-BETA-SEARCH(state) returns an action
		// inputs: state, current state in game
		// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
		// return the action in SUCCESSORS(state) with value v
		@Override
		public void execute(Node node) {
			// Enter your code here
			System.out.println(maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE)); 
		}

		// function MAX-VALUE(state, alpha, beta) returns a utility value
		// if TERMINAL-TEST(state) then return UTILITY(state)
		// v <- MIN_VALUE;
		// for each s in SUCCESSORS(state) do
		// v <- MAX(v, MIN-VALUE(s, alpha, beta))
		// if v >= beta then return v
		// alpha <- MAX(alpha, v)
		// return v

		public int maxValue(Node node, int alpha, int beta) {
			// Enter your code here
			System.out.print(node.getLabel());
			if(node.isTerminal()) return node.getValue();
			int maxVal = Integer.MIN_VALUE;
			List<Node> child = node.getChildren();
			child.sort(Node.LabelComparatorReverse);
			for(int i = 0 ; i < child.size() ; i++) {
				maxVal = Math.max(maxVal, minValue(child.get(i), alpha, beta));
				if(maxVal >= beta) return maxVal;
				alpha = Math.max(alpha, maxVal);
			}
			return alpha;
		}
		// function MIN-VALUE(state, alpha , beta) returns a utility value
		// if TERMINAL-TEST(state) then return UTILITY(state)
		// v <- Integer.MAX_VALUE
		// for each s in SUCCESSORS(state) do
		// v <- MIN(v, MAX-VALUE(s, alpha , beta))
		// if v <= alpha then return v
		// beta <- MIN(beta ,v)
		// return v

		public int minValue(Node node, int alpha, int beta) {
			// Enter your code here
			System.out.print(node.getLabel());
			if(node.isTerminal()) return node.getValue();
			int minVal = Integer.MAX_VALUE;
			List<Node> child = node.getChildren();
			child.sort(Node.LabelComparatorReverse);
			for(int i = 0 ; i < child.size() ; i++) {
				minVal = Math.min(minVal, maxValue(child.get(i), alpha, beta));
				if(minVal <= alpha) return minVal;
				beta = Math.min(beta, minVal);
			}
			return beta;
		}

}

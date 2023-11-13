package sa_tsp;

import java.util.List;

import Queen.Node;

public class HillClimbingAlgo implements Algothrims {

	@Override
	public Node execute(Node initialState) {
		// TODO Auto-generated method stub
		Node current = new Node(initialState);
		List<Node> neighbor = initialState.generateAllCandidates();
		while (true) {
			Node bestChoice = neighbor.get(0);
			for (int i = 0; i < neighbor.size(); i++) {
				if (bestChoice.getH() < neighbor.get(i).getH())
					bestChoice = neighbor.get(i);
			}
			if (current.getH() > bestChoice.getH()) {
				current = bestChoice;
				neighbor = current.generateAllCandidates();
			} else
				break;
		}
		return current;
	}

	@Override
	public Node executeHillClimbingWithRandomRestart(Node initialState) {
		Node current = this.execute(initialState);
		while (current.getH() != 0) {
			current.generateBoard();
			current = this.execute(current);
		}
		return current;
	}

	public static void main(String[] args) {
		Node node = new Node();
		node.generateBoard();
		node.displayBoard();

		System.out.println();

		HillClimbingAlgo algo = new HillClimbingAlgo();
//		Node result = algo.execute(node);
//		result.displayBoard();
//		Node result = algo.executeHillClimbingWithRandomRestart(node);
//		result.displayBoard();
		System.out.println("result");
	}

}

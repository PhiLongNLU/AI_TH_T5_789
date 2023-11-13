package sa_tsp;

import Queen.Node;

public interface Algothrims {
	public Node execute(Node initialState);

	public Node executeHillClimbingWithRandomRestart(Node initialState);
}

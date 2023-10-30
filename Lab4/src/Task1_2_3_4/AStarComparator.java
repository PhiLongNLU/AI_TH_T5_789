package Task1_2_3_4;

import java.util.Comparator;

public class AStarComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		if(o1.getG() - o2.getG() != 0) {
			return o1.getG() - o2.getG() > 0 ? 1 : -1;
		}
		else {
			return o1.getLabel().compareTo(o2.getLabel());
		}
	}

}

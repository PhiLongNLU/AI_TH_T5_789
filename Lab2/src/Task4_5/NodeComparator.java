package Task4_5;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node>{

	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		if(o1.getPathCost() - o2.getPathCost() != 0) {
			return (o1.getPathCost() - o2.getPathCost()) > 0 ? 1 : -1;
		}
		else return 0;
	}
	

}

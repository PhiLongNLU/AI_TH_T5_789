package Task1_2_3_4;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearchAlgo implements IInformedSearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new AStarComparator());
		List<Node> nodeTravelleds = new ArrayList<Node>();
		root.setH(0);
		frontier.add(root);
		
		
		while(!frontier.isEmpty()) {
			System.out.println(frontier);
			Node current = frontier.poll();
			nodeTravelleds.add(current);
			if(current.getLabel().equals(goal)) {
				return current;
			}
			else {
				List<Edge> children = current.getChildren();
				for(int i = 0 ; i < children.size() ; i++) {
					
					Node currentChild = new Node(children.get(i).getEnd());
					currentChild.setG(currentChild.getG() + currentChild.getH() + current.getG() - current.getH() );
					currentChild.setParent(current);
					if(!frontier.contains(currentChild) && !nodeTravelleds.contains(currentChild)) {
						frontier.add(currentChild);
					}
					
					else if(frontier.contains(currentChild)) {
						for (Node node : frontier) {
							if(  currentChild.getLabel().equals(node.getLabel()) && currentChild.getG() < node.getG()) {
								frontier.remove(node);
								frontier.add(currentChild);
								break;
							}
						}
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new AStarComparator());
		List<Node> nodeTravelleds = new ArrayList<Node>();
		frontier.add(root);
		
		Loop:
		while(!frontier.isEmpty()) {
			System.out.println(frontier);
			Node current = frontier.poll();
			nodeTravelleds.add(current);
		
			if(current.getLabel().equals(goal)) {
				return current;
			}
			else {
				List<Edge> children = current.getChildren();
				for(int i = 0 ; i < children.size() ; i++) {
					
					Node currentChild = new Node(children.get(i).getEnd());
					if(currentChild.getLabel().equals(start)) {
						frontier.clear();
						frontier.add(currentChild);
						continue Loop;
					}
					
					currentChild.setG(currentChild.getG() + currentChild.getH() + current.getG() - current.getH() );
					currentChild.setParent(current);
					if(!frontier.contains(currentChild) && !nodeTravelleds.contains(currentChild)) {
						frontier.add(currentChild);
					}
					
					else if(frontier.contains(currentChild)) {
						for (Node node : frontier) {
							if(  currentChild.getLabel().equals(node.getLabel()) && currentChild.getG() < node.getG()) {
								frontier.remove(node);
								frontier.add(currentChild);
								break;
							}
						}
					}
				}
			}
		}
		return null;
	}


	@Override
	public boolean isAdmissibleH(Node root, String goal) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				PriorityQueue<Node> frontier = new PriorityQueue<Node>(new AStarComparator());
				List<Node> nodeTravelleds = new ArrayList<Node>();
				Node start = new Node(root);
				start.setH(0);
				frontier.add(start);
				Node nodeGoal = null;
				
				while(!frontier.isEmpty()) {
					System.out.println(frontier);
					Node current = frontier.poll();
					nodeTravelleds.add(current);
					if(current.getLabel().equals(goal)) {
						nodeGoal = current;
						break;
					}
					else {
						List<Edge> children = current.getChildren();
						for(int i = 0 ; i < children.size() ; i++) {
							
							Node currentChild = new Node(children.get(i).getEnd());
							currentChild.setG(currentChild.getG() + currentChild.getH() + current.getG() - current.getH() );
							currentChild.setParent(current);
							if(!frontier.contains(currentChild) && !nodeTravelleds.contains(currentChild)) {
								frontier.add(currentChild);
							}
							
							else if(frontier.contains(currentChild)) {
								for (Node node : frontier) {
									if(  currentChild.getLabel().equals(node.getLabel()) && currentChild.getG() < node.getG()) {
										frontier.remove(node);
										frontier.add(currentChild);
										break;
									}
								}
							}
						}
					}
				}
				
				if(root.getH() <= nodeGoal.getH() && root.getH() >= 0) {
					return true;
				}
				else {
					return false;
				}
	}

	
}

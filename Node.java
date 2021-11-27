//Node.java
import java.util.Dictionary;

public class Node {
	private String name;
	private Dictionary<Node, Integer> adjacencyList; //this will be if we want to only store the edge weights
	/*
	this is for if we dont want to store weights and instead put all nodes in an xy plane and then
	calculate node weights based on distance. this needs a Coordinate class but thats easy

	private ArrayList<Node> adjacencyList;
	private Coordinate coord;
	*/
}

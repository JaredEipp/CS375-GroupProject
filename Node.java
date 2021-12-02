//Node.java
import java.util.Dictionary;
import java.util.Hashtable;

public class Node {
	private String name;
	private Dictionary<Node, Integer> adjacencyList; //this will be if we want to only store the edge weights
	/*
	this is for if we dont want to store weights and instead put all nodes in an xy plane and then
	calculate node weights based on distance. this needs a Coordinate class but thats easy

	private ArrayList<Node> adjacencyList;
	private Coordinate coord;
	*/
	
	public Node(String name) {

		this.name = name;
		adjacencyList = new Hashtable<Node, Integer>(); //Easy lookup, 
		//NOTE: Could change key to string and use getName() function

	}

	public String getName() {
		return name;
	}

	public void addEdge(Node dest, Integer weight, boolean reverse) { //Must call addEdge(this, weight) for opposite edge

		adjacencyList.put(dest, weight);

		/*
		Bool prevents infinite loop, but might be easier to just call
		addEdge twice in the final implmentation
		*/
		if(!reverse) {
			dest.addEdge(this, weight, true); 
		}
		
	}

	

}

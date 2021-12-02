//Graph.java
import java.util.List;

public abstract class Graph implements GraphInterface {

	private List<Node> nodeList;
	private List<Edge> edgeList;
	private Integer maxNodes;

	public Graph(Integer maxNodes) {
		this.maxNodes = maxNodes;
		init();
	}

	public void init() {
		nodeList = new List<Node>();
		edgeList = new List<Edge>();
	}

	//To add nodes, just add to a list
	public void addNode(Node n) {
		nodeList.add(n);
	}

	//Check nodes to see if node n is already in the graph
	//This is useful with addEdge
	public boolean checkNode(Node n) {
		for(Node m : nodeList) {
			if(n.getName().equals(m.getName()) {
				return true;
			}
		}
		return false;
	}

	/*
	To add an edge to the graph, just specify the two nodes and connect them
	with specified weight
	Since edges can be between already added nodes, check if they exist in the list first
	*/
	public void addEdge(Node src, Node dest, Integer weight) {

		if(!checknode(src) {
			addNode(src);
		}else if(!checknode(dest)) {
			addNode(dest);
		}
		src.addEdge(dest, weight, false); //Adds both edges (u,v) and (v,u) to adjacency lists
		edgeList.add(new Edge(src, dest, weight));
		edgeList.add(new Edge(dest, src, weight));

	}

	public void generateMinSpanningTree() {
	
		//Implement Kruskals
	
	}
	
	//NOTE: edgeList contains edges (u,v) and (v,u) so delete both in the respective data structures
	public abstract void getShortestPath();
	
}

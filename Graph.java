//Graph.java
import java.util.List;

public abstract class Graph implements GraphInterface {

	private List<Node> nodeList;
	private List<Edge> edgeList;
	private Integer nodes;

	public Graph() {
		nodes = 0;
		init();
	}

	public void init() {
		nodeList = new List<Node>();
		edgeList = new List<Node>();
	}

	//To add nodes, just add to a list
	public void AddNode(Node n) {
		nodeList.add(n);
	}

	/*
	To add an edge to the graph, just specify the two nodes and connect them
	with specified weight
	*/
	public void addEdge(Node src, Node dest, Integer weight) {

		src.addEdge(dest, weight, false); //Adds both edges (u,v) and (v,u)

	}

	public void generateMinSpanningTree() {
	
		//Implement Kruskals
	
	}

	public void DFS() { //Call DFS to add all possible edges to the list, and prevent repeats from appearing which would hinder the heaps

		//All nodes initialized as white already


	}

	public abstract void getShortestPath();
	
}

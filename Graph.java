//Graph.java
import java.util.List;
import java.util.ArrayList;

public abstract class Graph implements GraphInterface {

	protected List<Node> nodeList;
	protected List<Edge> edgeList;
	private List<Edge> MST;
	protected Integer maxNodes;

	public Graph(Integer maxNodes) {
		this.maxNodes = maxNodes;
		MST = new ArrayList<Edge>();
		init();
	}

	public void init() {
		nodeList = new ArrayList<Node>();
		edgeList = new ArrayList<Edge>();
	}

	//To add nodes, just add to a list
	public void addNode(Node n) {
		nodeList.add(n);
	}

	//Check nodes to see if node n is already in the graph
	//This is useful with addEdge
	public boolean checkNode(Node n) {
		for(Node m : nodeList) {
			if(n.getName().equals(m.getName())) {
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

		if(!checkNode(src)) {
			addNode(src);
		}else if(!checkNode(dest)) {
			addNode(dest);
		}
		src.addEdge(dest, weight, false); //Adds both edges (u,v) and (v,u) to adjacency lists
		edgeList.add(new Edge(src, dest, weight));
		edgeList.add(new Edge(dest, src, weight));

	}

	public void generateMinSpanningTree() {
	
		//Implement Kruskals
		for(Node n : nodeList) {
			//TODO: Make a set class 
		}
		Edge lowest = getShortestEdge(true);
		//TODO: find-set functions
		/*if(find-set(u) != find-set(v)) { 
			MST.add(lowest);
			union(u,v);
		}*/
		for(int i = 1; i < edgeList.size() / 2; i++) { //Since (u,v) and (v,u) are both included, loop half the size
			Edge shortest = getShortestEdge(false);
			Node src = shortest.getSrc();
			Node dest = shortest.getDest();
			/*if(find-set(src) != find-set(dest)) {
				MST.add(lowest);
				union(src,dest)
			}*/
		}
	
	}
	
	//NOTE: edgeList contains edges (u,v) and (v,u) so delete both in the respective data structures
	//added boolean arg so sorting the edges can be done in this function as well
	//changed to return the edges, so for sort = true: sort and return root
	//for false, just return the root and delete, since already sorted
	public abstract Edge getShortestEdge(boolean sort);
	
}

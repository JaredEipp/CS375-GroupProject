//Graph.java
import java.util.List;
import java.util.ArrayList;

public abstract class Graph implements GraphInterface {

	protected List<Node> nodeList;
	protected List<Edge> edgeList;
	private List<Edge> MST;
	protected Integer maxNodes;
	private SetContainer sc;

	public Graph(Integer maxNodes) {
		this.maxNodes = maxNodes;
		sc = new SetContainer();
		MST = new ArrayList<Edge>();
		init();
	}

	public void init() {
		nodeList = new ArrayList<Node>();
		edgeList = new ArrayList<Edge>();
	}

	public List<Edge> getMST() {
		return MST;
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
		int index = 0;
		for(Node n : nodeList) {
			Set s = new Set(); 
			n.setRepresentative(n);
			s.addNode(n);
			sc.addSet(s);
			/* This part properly adds the nodes to their own set and makes themselves their own representative
			System.out.println("Added Node " + n.getName() + " to its own set");
			System.out.println("Gave set representative " + n.getRepresentative().getName());
			*/
			nodeList.set(index, n);
			index++;
		}

		Node u = null;
		Node v = null;
		int index_u = -1;
		int index_v = -1;
		Edge lowest = getShortestEdge(true);
		for(int i = 0; i < nodeList.size(); i++) {
			if(lowest.getSrc().getName().equals(nodeList.get(i).getName())) {
				u = lowest.getSrc();
				index_u = i;
			}else if(lowest.getDest().getName().equals(nodeList.get(i).getName())) {
				v = lowest.getDest();
				index_v = i;
			}
		}
		if(sc.sameSet(u, v)) { 
			MST.add(lowest);
			nodeList = sc.union(u, v, nodeList);
		}
		/*
		for(int i = 1; i < edgeList.size() / 2; i++) { //Since (u,v) and (v,u) are both included, loop half the size
			Edge shortest = getShortestEdge(false);
			Node src = shortest.getSrc();
			Node dest = shortest.getDest();
			Node a = null;
			Node b = null;
			for(Node m : nodeList) {
				if(src.getName().equals(m.getName())) {
					a = src;
				}else if(dest.getName().equals(m.getName())) {
					b = dest;
				}
			}
			if(sc.sameSet(a, b)) {
				MST.add(shortest);
			}
		}
		*/
	}

	
	//NOTE: edgeList contains edges (u,v) and (v,u) so delete both in the respective data structures
	//added boolean arg so sorting the edges can be done in this function as well
	//changed to return the edges, so for sort = true: sort and return root
	//for false, just return the root and delete, since already sorted
	public abstract Edge getShortestEdge(boolean sort);
	
}

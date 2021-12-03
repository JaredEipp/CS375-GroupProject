//SimpleGraph.java
import java.util.List;
import java.util.ArrayList;

public class SimpleGraph extends Graph {

	public SimpleGraph(Integer maxNodes) {
		super(maxNodes);
	}

	public void init() {
		super.init();
	}

	//To add nodes, just add to a list
	public void addNode(Node n) {
		super.addNode(n);
	}

	//Check nodes to see if node n is already in the graph
	//This is useful with addEdge
	public boolean checkNode(Node n) {
		return super.checkNode(n);
	}

	/*
	To add an edge to the graph, just specify the two nodes and connect them
	with specified weight
	Since edges can be between already added nodes, check if they exist in the list first
	*/
	public void addEdge(Node src, Node dest, Integer weight) {
		super.addEdge(src, dest, weight);
	}

	public void generateMinSpanningTree() {
		super.generateMinSpanningTree();	
	}
	
	//NOTE: edgeList contains edges (u,v) and (v,u) so delete both in the respective data structures
	//added boolean arg so sorting the edges can be done in this function as well
	//changed to return the edges, so for sort = true: sort and return root
	//for false, just return the root and delete, since already sorted
	public Edge getShortestEdge(boolean sort) {
		for (int i = 0; i < edgeList.size(); i++) {
			for (int j = i; j < edgeList.size(); j++) {
				if (edgeList.get(i).getWeight() > edgeList.get(j).getWeight()) {
					Edge tmp = edgeList.get(i);
					edgeList.set(i, edgeList.get(j));
					edgeList.set(j, tmp);
				}
			}
		}
		Edge shortest = edgeList.get(0);
		edgeList.remove(0);
		return shortest;
	}
	
}
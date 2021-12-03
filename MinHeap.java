//MinHeap.java

public class MinHeap extends Graph {

	public MinHeap(int w) {
		super(w);
	}

	public void init() {
		super.init();
	}

	public void addNode(Node n) {
		super.addNode(n);
	}

	public boolean checkNode(Node n) {
		return super.checkNode(n);
	}

	public void addEdge(Node src, Node dest, int weight) {
		super.addEdge(src, dest, weight);
	}

	public void generateMinSpanningTree() {
		super.generateMinSpanningTree();
	}

	public Edge getShortestEdge(boolean sort) {

		if(sort) {
			buildMinHeap();
			return extractMin();
		}
		else
			return extractMin();

	}

	public void minHeapify(List<Edge> eList, Integer index, Integer s) {

		for(Edge e : edgeList) {

		}

	}

	public void buildMinHeap() {

		for(i = (edgeList.size() / 2) - 1; i >= 0; i--) {
			minHeapify(edgeList, i, edgeList.size());
		}

	}

	public Edge extractMin() {

		Edge min = edgeList.get(0);
		edgeList.remove(0)
		edgeList.remove(1)
		return min;

	}

}

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

	public void minHeapify(Integer index) {
		Integer l = (2*(index + 1)) - 1;
		Integer r = (2*(index + 1) + 1) - 1;
		Edge current = edgeList.get(index);
    Edge left = edgeList.get(l);
		Edge right = edgeList.get(r);
		Integer min;
		if(l <= (edgeList.size() - 1) && left.getWeight() < current.getWeight())
		  min = l;
		else
			min = index;
		if(r <= (edgeList.size() - 1) && right.getWeight() < edgeList.get(min).getWeight())
			min = r;
		if(min != index)
		  edgeList.set(index, edgeList.get(min));
			edgeList.set(min, current);
			minHeapify(min);
	}

	public void buildMinHeap() {

		for(int i = (edgeList.size() / 2) - 1; i >= 0; i--) {
			minHeapify(i);
		}

	}

	public Edge extractMin() {

		Edge min = edgeList.get(0);
		edgeList.remove(0);
		edgeList.set(0, edgeList.get(edgeList.size() - 1));
		edgeList.remove(edgeList.get(edgeList.size() - 1));
		minHeapify(0);
		return min;

	}

}

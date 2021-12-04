//MinHeap.java

import java.util.ArrayList;
import java.util.List;

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

	public List<Edge> getMST() {
		return super.getMST();
	}

	public boolean checkNode(Node n) {
		return super.checkNode(n);
	}

	public void addEdge(Node src, Node dest, int weight) {
		super.addEdge(src, dest, weight);
	}

	public ArrayList<String> generateMinSpanningTree() {
		return super.generateMinSpanningTree();
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
		Integer l = 2*(index ) + 1;
		Integer r = 2*(index) + 2;
		Integer min;
		if(l <= (edgeList.size() - 1) 
			&& edgeList.get(l).getWeight() < edgeList.get(index).getWeight())
		  min = l;
		else
			min = index;
		if(r <= (edgeList.size() - 1) 
			&& edgeList.get(r).getWeight() < edgeList.get(min).getWeight())
			min = r;
		if(min != index) {
			Edge current = edgeList.get(index);
		  edgeList.set(index, edgeList.get(min));
			edgeList.set(min, current);
			minHeapify(min);
		}
	}

	public void buildMinHeap() {

		for(int i = edgeList.size() - 1; i >= 0; i--) {
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

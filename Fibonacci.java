//Fibonacci.java

import java.util.ArrayList;
import java.util.List;

public class Fibonacci extends Graph {
//	private FibHelper heap;
	private fib2 heap;

	public Fibonacci(int w) {
		super(w);
		heap = new fib2();
	//	heap = new FibHelper();
	}
	
	public void init() {
		super.init();
	}

	public List<Edge> getMST() {
		return super.getMST();
	}

	public void addNode(Node n) {
		super.addNode(n);
	}

	public boolean checkNode(Node n) {
		return super.checkNode(n);
	}

	public void addEdge(Node src, Node dest, int weight) {
		super.addEdge(src, dest, weight);
//		heap.insert(src, dest, weight);
//		heap.insert(new Cell(src, dest, weight));
	}

	public ArrayList<String> generateMinSpanningTree() {
		return super.generateMinSpanningTree();
	}

	public Edge getShortestEdge(boolean sort) {
		if (sort) {
			for (Edge e : edgeList) {
				heap.insert(e.getSrc(), e.getDest(), e.getWeight());
				//heap.insert(new Cell(e.getSrc(), e.getDest(), e.getWeight()));
			}
		}
		Cell ret = heap.extractMin();
		if (ret != null) {
			edgeList.remove(ret);
			return new Edge(ret.getSrc(), ret.getDest(), ret.getWeight());
		}
		return null;
	}

}

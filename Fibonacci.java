//Fibonacci.java

public class Fibonacci extends Graph {
//	private FibHelper heap;
	private fib2 heap;

	public Fibonacci(int w) {
		super(w);
		heap = new fib2();
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
		heap.insert(src, dest, weight);
	}

	public void generateMinSpanningTree() {
		super.generateMinSpanningTree();
	}

	public Edge getShortestEdge(boolean sort) {
		Cell ret = heap.extractMin();
		if (ret != null)
			return new Edge(ret.getSrc(), ret.getDest(), ret.getWeight());
		return null;
	}

}

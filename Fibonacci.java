//Fibonacci.java

public class Fibonacci extends Graph {
	private FibHelper heap;

	public Fibonacci(int w) {
		super(w);
		heap = new FibHelper();
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
		heap.insert(new Cell(weight));
	}

	public void generateMinSpanningTree() {
		super.generateMinSpanningTree();
	}

	public Edge getShortestEdge(boolean sort) {
		//do Someting here
		return null;
	}

}

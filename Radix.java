//Radix.java

public class Radix extends Graph {

	public Radix(int w) {
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
		//do Someting here
		return null;
	}

	public int getMaxWeight() {
		int m = edgeList.get(0).getWeight();
		for(Node n : nodeList) {
			if(n.getWeight() > m) {
				m = n.getWeight();
			}
		}
	}

	public void countingSort(int e) {
		int i = 0;
		Edge[] count = new Edge[10];
		Arrays.fill(count, 0); //Set frequency of digits to zero

		for(i = 0; i < edgeList.size(); i++) {
			count[(edgeList.get(i).getWeight() / e) % 10]++;
		}

	}

	public void sortEdges() {

		int max = getMaxWeight();

		for(int e = 1; max/e > 0; e *= 10) {
			countingSort(e);
		}

	}

}

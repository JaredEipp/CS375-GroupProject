//Radix.java

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Radix extends Graph {

	public Radix(int w) {
		super(w);
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
	}

	public ArrayList<String> generateMinSpanningTree() {
		return super.generateMinSpanningTree();
	}

	public Edge extractMin() {
		//Remove edgeList[0] and wherever the reverse of that edge is
		Edge m = edgeList.get(0);
		edgeList.remove(0);
		return m;
	}

	public Edge getShortestEdge(boolean sort) {
		if(sort) { //Run radix sort
			sortEdges();
			return extractMin();
		}else { //Already sorted, get min
			return extractMin();
		}
	}

	public int getMaxWeight() {
		int m = edgeList.get(0).getWeight();
		for(Edge e : edgeList) {
			if(e.getWeight() > m) {
				m = e.getWeight();
			}
		}
		return m;
	}

	public void countingSort(int e) {
		int i = 0;
		int[] count = new int[10]; //Using 1 digit [0,9]
		Edge[] out = new Edge[edgeList.size()];
		Arrays.fill(count, 0); //Set frequency of digits to zero

		for(i = 0; i < edgeList.size(); i++) {
			count[(edgeList.get(i).getWeight() / e) % 10]++;
		}

		//offset
		for(i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}

		for(i = edgeList.size() - 1; i >= 0; i--) {
			out[count[(edgeList.get(i).getWeight() / e) % 10] - 1] = edgeList.get(i);
			count[(edgeList.get(i).getWeight() / e) % 10]--;
		}

		for(i = 0; i < edgeList.size(); i++) {
			edgeList.set(i, out[i]); //Sort based on output for digit x where log(10^x) = x
		}

	}

	public void sortEdges() {

		int max = getMaxWeight(); //Must get the max to determine number of iterations of counting sort

		for(int e = 1; max/e > 0; e *= 10) {
			countingSort(e);
		}

	}

}

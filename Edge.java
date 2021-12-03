import java.util.*;

/*
Edge class in case we wish to store the edges in the list and heaps
as a set for easier retrieval.
*/
public class Edge {

	private Node src;
	private Node dest;
	private Integer weight;
	
	//Contructor
	public Edge(Node src, Node dest, Integer weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	//Getter for weight, necesssary for the data strucures
	Integer getWeight() {
		return weight;
	}

	public Node getSrc() {
		return src;
	}

	public Node getDest() {
		return dest;
	}

}

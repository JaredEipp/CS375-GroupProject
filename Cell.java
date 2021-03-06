//Cell.java
//this is the node class for the Fibonacci heap, but we already have a node class
//so it will be called a cell

public class Cell {
	private Cell parent;
	private Cell left;
	private Cell right;
	private Cell child;
	private int degree;
	private boolean mark; //?
	private int weight;
	private Node src;
	private Node dest;

	public Cell() {
		parent = null;
		left = null;
		right = null;
		child = null;
		degree = 0;
		mark = false;
		src = null;
		dest = null;
		weight = Integer.MAX_VALUE;
	}

	public Cell(Node s, Node d, int weight) {
		parent = null;
		left = null;
		right = null;
		child = null;
		degree = 0;
		mark = false;
		src = s;
		dest = d;
		this.weight = weight;
	}

	//SETTER METHODS

	public void setParent(Cell c) {
		parent = c;
	}

	public void setLeft(Cell c) {
		left = c;
	}

	public void setRight(Cell c) {
		right = c;
	}

	public void setChild(Cell c) {
		child = c;
	}

	public void setDegree(int d) {
		degree = d;
	}

	public void setMark(boolean b) {
		mark = b;
	}

	public void setWeight(int w) {
		weight = w;
	}

	public void setSrc(Node s) {
		src = s;
	}

	public void setDest(Node d) {
		dest = d;
	}

	//GETTER METHODS

	public Cell getParent() {
		return parent;
	}

	public Cell getLeft() {
		return left;
	}

	public Cell getRight() {
		return right;
	}

	public Cell getChild() {
		return child;
	}

	public int getDegree() {
		return degree;
	}

	public boolean getMark() {
		return mark;
	}

	public int getWeight() {
		return weight;
	}

	public Node getSrc() {
		return src;
	}

	public Node getDest() {
		return dest;
	}
}

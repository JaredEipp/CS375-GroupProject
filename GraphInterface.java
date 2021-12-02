//GraphInterface.java

public interface GraphInterface {
	public void init();
	public void addNode(Node n); 
	public void generateMinSpanningTree();
	public abstract Edge getShortestEdge(boolean sort);
}

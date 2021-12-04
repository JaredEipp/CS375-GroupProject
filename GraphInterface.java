//GraphInterface.java

import java.util.ArrayList;

public interface GraphInterface {
	public void init();
	public void addNode(Node n); 
	public ArrayList<String> generateMinSpanningTree();
	public abstract Edge getShortestEdge(boolean sort);
}

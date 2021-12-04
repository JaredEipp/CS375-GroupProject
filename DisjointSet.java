//DisjointSet

public class DisjointSet {

	/*Since nodes are classified as numbers from 0 to n-1, can use array with
	indices as the int of the string names
	*/
	int[] depth
	int[] parent;
	int size;

	public DisjointSet(int size) {
		this.size = size;
		rank = new int[size];
		parent = new int[size];
		makeSet();
	}

	//Since at the start, every vertex is its own parent
	public void makeSet() {
		for(int i = 0; i < size; i++) {
			parent[i] = i;
		}
	}

	//Find-set in class, but the parent of a node is the value at its index,
	//which is the int of the node's name
	public int find-set(int x) {
		if(parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	public void union(int x, int y) {
		
		int xRep = find-set(x);
		int yRep = find-set(y);

		/*
		Cases for when the set for x is either the same depth/size of y, greater than, or less than
		And also unions the sets of course
		*/
		if(depth[xRep] < depth[yRep]) {
			parent[xRep] = yRep;
		}else if(depth[xRep] > depth[yRep]) {
			parent[yRep] = xRep;
		}else {
			parent[yRep] = xRep;
			depth[xRep] = depth[xRep] + 1;
		}

	}

}

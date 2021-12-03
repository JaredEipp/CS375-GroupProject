//Set.java

import java.util.List;
import java.util.ArrayList;

public class Set {

	private List<Node> set;
	private Node rep; //Representative

	public Set() {
		set = new ArrayList<Node>();
		rep = null;
	}

	public List<Node> getList() {
		return set;
	}

	public Node getRep() {
		return rep;
	}

	public void addNode(Node n) {
		if(set.size() == 0) {
			rep = n;
		}
		set.add(n);
		n.setRepresentative(rep);
	}

	public boolean find(Node u) {
		/*boolean b = false;
		for(Node n : set) {
			if(n.getName().equals(u.getName())) {
				b = true;
				break;
			}
		}
		return b;*/
		return (rep.getName().equals(u.getRepresentative().getName()));
	}

}

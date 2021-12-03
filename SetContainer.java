//SetContainer.java

import java.util.List;
import java.util.ArrayList;

public class SetContainer {

	private List<Set> sets;

	public SetContainer() {
		sets = new ArrayList<Set>();
	}

	public void addSet(Set s) {
		sets.add(s);
	}

	public boolean sameSet(Node u, Node v) {
		boolean disjoint = true;
		Set a = null;
		Set b = null;
		Node rep_u = u;
		Node rep_v = v;
		for(Set s : sets) {
			if(s.find(u)) {
				rep_u = s.getRep();
				a = s;
			}else if(s.find(v)) {
				rep_v = s.getRep();
				b = s;
			}
			if(rep_u.getName().equals(rep_v.getName())) {
				disjoint = false;
				break;
			}
		}
		if(disjoint) {
			union(a, b);
		}
		return disjoint; //If disjoint, then we add to MST in graph
	}

	public void union(Set s, Set t) {

		int index1 = sets.indexOf(s);
		int index2 = sets.indexOf(t);
		for(Node n : t.getList()) {
			s.addNode(n);
			sets.set(index1, s);
		}

		sets.remove(index2);

	}

}

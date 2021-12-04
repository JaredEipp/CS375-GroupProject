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
		Node rep_u = u.getRepresentative();
		Node rep_v = v.getRepresentative();
		/*for(Set s : sets) {
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
		}*/
		if(rep_u.getName().equals(rep_v.getName())) {
			disjoint = false;
		}
		return disjoint; //If disjoint, then we add to MST in graph
	}

	public List<Node> union(Node u, Node v, List<Node> nodeList) {

		/*int index1 = sets.indexOf(s);
		int index2 = sets.indexOf(t);
		for(Node n : t.getList()) {
			s.addNode(n);
			sets.set(index1, s);
		}

		sets.remove(index2);*/
		int index1 = -1;
		int index2 = -1;
		for(int i = 0; i < sets.size(); i++) {
			if(sets.get(i).find(u)) {
				index1 = i;
			}else if(sets.get(i).find(v)) {
				index2 = i;
			}
			if(index1 != -1 && index2 != -1) {
				break;
			}
		}
		Set t = null;
		Set s = sets.get(index2);	
		for(Node n : t.getList()) {
			t = sets.get(index1);
			t.addNode(n);
			sets.set(index1, t);
		}

		sets.remove(index2);

	}

}

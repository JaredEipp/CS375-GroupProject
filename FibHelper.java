//FibHelper.java
//This class is here because the merge method would become a mess
//since there is only one Fibonacci object

public class FibHelper {
	private Cell min;
	private int totalCells;
	private boolean trace; //?
	private Cell found; //?

	public FibHelper() {
		min = null;
		totalCells = 0;
		trace = false;
	}

	public void setTrace(boolean t) {
		trace = t;
	}

	public boolean getTrace() {
		return trace;
	}
	
	public void setMin(Cell c) {
		min = c;
	}

	public Cell getMin() {
		return min;
	}

	public void setTotalCells(int t) {
		totalCells = t;
	}

	public int getTotalCells() {
		return totalCells;
	}

	public void insert(Cell c) {
		if (min == null) {
			min = c;
			c.setRight(min);//this and the one below point left and right
			c.setLeft(min); //node to min since there is only one heap
		} else {
			c.setRight(min);
			c.setLeft(min);
			Cell l = min.getLeft();
			l.setRight(c);
			if (c.getWeight() < min.getWeight())
				min = c;
		//this creates a new heap with one element placed to the left of min
		}
		totalCells++;
	}

	public static void merge(FibHelper f1, FibHelper f2, FibHelper f3) {
		f3.setMin(f1.getMin());
		if (f1.min != null && f2.min != null) {
			Cell c1 = f1.getMin().getLeft();
			Cell c2 = f2.getMin().getLeft();
			f1.getMin().setLeft(c2);
			c1.setRight(f2.getMin());
			f2.getMin().setLeft(c1);
			c2.setRight(f1.getMin());
		}
		if (f1.getMin() == null || 
			(f2.getMin() != null && f2.getMin().getWeight() < f1.getMin().getWeight()))
			f3.setMin(f2.getMin());
		f3.setTotalCells(f1.getTotalCells() + f2.getTotalCells());
	}

	public int extractMin() {
		Cell ret = min;
		if (ret != null) {
			Cell c = ret.getChild();
			Cell k = c;
			Cell p;
			if (c != null) {
				do {
					p = c.getRight();
					insert(c);
					c.setParent(null);
					c = p;
				} while (c != null && c != k);
			}
			ret.getLeft().setRight(ret.getRight()); //set lefts right node to ret.right
			ret.getRight().setLeft(ret.getLeft()); //set right left node to ret.left
			ret.setChild(null);
			if (ret == ret.getRight())
				min = null;
			else {
				min = ret.getRight();
				consolidate();
			}
			totalCells--;
			return ret.getWeight();
		}
		return -1;
	}

	public void consolidate() {
		double phi = (1 + Math.sqrt(5)) / 2; //Fibonacci constant
		int degrees = (int)(Math.log(totalCells) / Math.log(phi));
		Cell[] arr = new Cell[degrees+1];
		for (int i = 0; i <= degrees; ++i) 
			arr[i] = null;
		Cell c = min;
		if (c != null) {
			Cell check = min;
			do {
				Cell x = c;
				int d = x.getDegree();
				while(arr[d] != null) {
					Cell y = arr[d];
					if (x.getWeight() > y.getWeight()) {
						Cell temp = x;
						x = y;
						y = temp;
						c = x;
					}
					link(y,x);
					check = x;
					arr[d] = null;
					d++;
				}
				arr[d] = x;
				c = c.getRight();
			} while (c != null && c != check);
			min = null;
			for (int i = 0; i < degrees; ++i) {
				if (arr[i] != null)
					insert(arr[i]);
			}
		}
	}

	public void link(Cell y, Cell x) {
		y.getLeft().setRight(y.getRight()); //remove y from linked list
		y.getRight().setLeft(y.getLeft());  //step 2 of above

		Cell c = x.getChild();
		if (c == null) {
			y.setRight(y);
			y.setLeft(y);
		} else {
			y.setRight(c);
			y.setLeft(c.getLeft());
			c.getLeft().setRight(y);
			c.setLeft(y);
		}
		y.setParent(x);
		x.setChild(y);
		x.setDegree(x.getDegree() + 1);
		y.setMark(false);
	}

}

// Operations on Fibonacci Heap in Java

public class fib2 {
  Cell min;
  int n;
  boolean trace;
  Cell found;

  public boolean getTrace() {
    return trace;
  }

  public void setTrace(boolean t) {
    this.trace = t;
  }

  public static fib2 create_heap() {
    return new fib2();
  }

  fib2() {
    min = null;
    n = 0;
    trace = false;
  }

  private void insert_Cell(Cell x) {
    if (min == null) {
      min = x;
      x.setLeft(min);
      x.setRight(min);
    } else {
      x.setRight(min);
      x.setLeft(min.getLeft());
      min.getLeft().setRight(x);
      min.setLeft(x);
      if (x.getWeight() < min.getWeight())
        min = x;
    }
    n += 1;
  }

  public void insert(Node src, Node dest, int key) {
    insert_Cell(new Cell(src, dest, key));
  }

  public void display() {
    display(min);
    System.out.println();
  }

  private void display(Cell c) {
    System.out.print("(");
    if (c == null) {
      System.out.print(")");
      return;
    } else {
      Cell temp = c;
      do {
        System.out.print(temp.getWeight());
        Cell k = temp.getChild();
        display(k);
        System.out.print("->");
        temp = temp.getRight();
      } while (temp != c);
      System.out.print(")");
    }
  }

  public static void merge_heap(fib2 H1, fib2 H2, fib2 H3) {
    H3.min = H1.min;

    if (H1.min != null && H2.min != null) {
      Cell t1 = H1.min.getLeft();
      Cell t2 = H2.min.getLeft();
      H1.min.setLeft(t2);
      t1.setRight(H2.min);
      H2.min.setLeft(t1);
      t2.setRight(H1.min);
    }
    if (H1.min == null || (H2.min != null && H2.min.getWeight() < H1.min.getWeight()))
      H3.min = H2.min;
    H3.n = H1.n + H2.n;
  }

  public int find_min() {
    return this.min.getWeight();
  }

  private void display_Cell(Cell z) {
    System.out.println("right: " + ((z.getRight() == null) ? "-1" : z.getRight().getWeight()));
    System.out.println("left: " + ((z.getLeft() == null) ? "-1" : z.getLeft().getWeight()));
    System.out.println("child: " + ((z.getChild() == null) ? "-1" : z.getChild().getWeight()));
    System.out.println("degree " + z.getDegree());
  }

  public Cell extractMin() {
    Cell z = this.min;
    if (z != null) {
      Cell c = z.getChild();
      Cell k = c, p;
      if (c != null) {
        do {
          p = c.getRight();
          insert_Cell(c);
          c.setParent(null);
          c = p;
        } while (c != null && c != k);
      }
      z.getLeft().setRight(z.getRight());
      z.getRight().setLeft(z.getLeft());
      z.setChild(null);
      if (z == z.getRight())
        this.min = null;
      else {
        this.min = z.getRight();
        this.consolidate();
      }
      this.n -= 1;
      return z;
    }
    return null;
  }

  public void consolidate() {
    double phi = (1 + Math.sqrt(5)) / 2;
    int Dofn = (int) ((Math.log(this.n) / Math.log(phi)));
    Cell[] A = new Cell[Dofn + 4];
    for (int i = 0; i <= Dofn; ++i)
      A[i] = null;
    Cell w = min;
    if (w != null) {
      Cell check = min;
      do {
        Cell x = w;
        int d = x.getDegree();
        while (A[d] != null) {
          Cell y = A[d];
          if (x.getWeight() > y.getWeight()) {
            Cell temp = x;
            x = y;
            y = temp;
            w = x;
          }
          fib_heap_link(y, x);
          check = x;
          A[d] = null;
          d += 1;
        }
        A[d] = x;
        w = w.getRight();
      } while (w != null && w != check);
      this.min = null;
      for (int i = 0; i <= Dofn; ++i) {
        if (A[i] != null) {
          insert_Cell(A[i]);
        }
      }
    }
  }

  // Linking operation
  private void fib_heap_link(Cell y, Cell x) {
    y.getLeft().setRight(y.getRight());
    y.getRight().setLeft(y.getLeft());

    Cell p = x.getChild();
    if (p == null) {
      y.setRight(y);
      y.setLeft(y);
    } else {
      y.setRight(p);
      y.setLeft(p.getLeft());
      p.getLeft().setRight(y);
      p.setLeft(y);
    }
    y.setParent(x);
    x.setChild(y);
    x.setDegree(x.getDegree() + 1);
    y.setMark(false);
  }

  // Search operation
  private void find(int key, Cell c) {
    if (found != null || c == null)
      return;
    else {
      Cell temp = c;
      do {
        if (key == temp.getWeight())
          found = temp;
        else {
          Cell k = temp.getChild();
          find(key, k);
          temp = temp.getRight();
        }
      } while (temp != c && found == null);
    }
  }

  public Cell find(int k) {
    found = null;
    find(k, this.min);
    return found;
  }

  public void decrease_key(int key, int nval) {
    Cell x = find(key);
    decrease_key(x, nval);
  }

  // Decrease key operation
  private void decrease_key(Cell x, int k) {
    if (k > x.getWeight())
      return;
    x.setWeight(k);
    Cell y = x.getParent();
    if (y != null && x.getWeight() < y.getWeight()) {
      cut(x, y);
      cascading_cut(y);
    }
    if (x.getWeight() < min.getWeight())
      min = x;
  }

  // Cut operation
  private void cut(Cell x, Cell y) {
    x.getRight().setLeft(x.getLeft());
    x.getLeft().setRight(x.getRight());

    y.setDegree(y.getDegree() - 1);

    x.setRight(null);
    x.setLeft(null);
    insert_Cell(x);
    x.setParent(null);
    x.setMark(false);
  }

  private void cascading_cut(Cell y) {
    Cell z = y.getParent();
    if (z != null) {
      if (y.getMark() == false)
        y.setMark(true);
      else {
        cut(y, z);
        cascading_cut(z);
      }
    }
  }

  // Delete operations
  public void delete(Cell x) {
    decrease_key(x, Integer.MIN_VALUE);
    Cell p = extractMin();
  }
}

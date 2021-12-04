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

}

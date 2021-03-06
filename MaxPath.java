import java.util.*;

public class MaxPath {

  public static class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int v, Node l, Node r) {
      this.value = v;
      this.left = l;
      this.right = r;
    }
    public Node(int v) {
      this(v, null, null);
    }
  }

  public static class SearchResult {
    private int max;
    private String path;

    public SearchResult(int x, String p) {
      this.max = x;
      this.path = p;
    }
    public int getMax() { return max; }
    public String getPath() { return path; }
   
  }

  public static SearchResult maxPath(Node n) {
    if (n == null)
      return new SearchResult(0, "");
    if (n.left == null && n.right == null)
      return new SearchResult(n.value, String.valueOf(n.value));
    SearchResult solveLeft = maxPath(n.left);
    SearchResult solveRight = maxPath(n.right);
    if (solveLeft.getMax() > solveRight.getMax()) {
      return new SearchResult(n.value + solveLeft.getMax(), n.value + " + " + solveLeft.getPath());
    } else {
      return new SearchResult(n.value + solveRight.getMax(), n.value + " + " + solveRight.getPath());
    }
  }

  public static void main(String[] args) {
    Node root = new Node(3, 
                         new Node(5, 
                             new Node(1),
                             new Node(2)
                         ),
                         new Node(7, 
                             new Node(-2),
                             new Node(-3)
                         )
                );
    SearchResult s = maxPath(root);
    System.out.println("Max sum: " + s.getPath() + " = " + s.getMax());
  }
}

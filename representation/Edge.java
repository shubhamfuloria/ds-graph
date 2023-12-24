package representation;

public class Edge {
  public int source;
  public int neighbour;
  public int weight;

  public Edge(int source, int neighbour, int weight) {
    this.source = source;
    this.neighbour = neighbour;
    this.weight = weight;
  }
}

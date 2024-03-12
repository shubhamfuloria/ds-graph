import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

public class MinSpanningTree {
  /*
   * What is Minimum Spanning Tree ?
   * 
   * Spanning Tree:-> A subgraph of a graph, which is tree (connected and acyclic)
   * and is spanning (will contain all vertices). Some of the edges may skip.
   * 
   * MST => Out of all the spanning trees possible, a spanning tree which has
   * minimum sum of weights of edges
   * 
   * 
   * Problem: A graph is given, we need to find, minimum spanning tree of the
   * graph
   * 
   * The algorithm is very similar to Dijkstra. But in this algorithm, we store
   * previous edge's weight instead of weight so far.
   * In each step, we choose next optimal path.
   * 
   * How does Dijkstra is different ?
   * The main differentiation is, in prims algorithm, no vertex can be skipped.
   * But in dikstra any vertex can be skipped, we just need to make sure that we
   * reach from source to destination in lowest cost
   * 
   * 
   */

  public static class Edge {
    public int source;
    public int neighbour;
    public int weight;

    public Edge(int source, int neighbour, int weight) {
      this.source = source;
      this.neighbour = neighbour;
      this.weight = weight;
    }
  }

  public static class Pair implements Comparable<Pair> {
    int v; // vertex
    int av; // aquiring vertex
    int wt; // weight so far

    Pair(int v, int av, int wt) {
      this.v = v;
      this.av = av;
      this.wt = wt;
    }

    public int compareTo(Pair to) {
      return this.wt - to.wt;
    }
  }

  public static void getMinSpanningTree(List<List<Edge>> graph, int source) {

    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.offer(new Pair(source, -1, 0));

    boolean[] visited = new boolean[graph.size()];

    while (!pq.isEmpty()) {

      Pair pair = pq.poll();

      if (visited[pair.v] == true) {
        continue;
      }

      visited[pair.v] = true;

      if (pair.av != -1) {
        System.out.println(pair.v + " av " + pair.av + " @ " + pair.wt);
      }
      for (Edge edge : graph.get(pair.v)) {
        if (visited[edge.neighbour] == false) {
          pq.offer(new Pair(edge.neighbour, pair.v, edge.weight));
        }
      }
    }

  }

  public static void main(String[] args) {

    List<List<Edge>> graph = new ArrayList<>();

    for (int i = 0; i < 7; i++) {
      graph.add(new ArrayList<>());
    }

    graph.get(0).add(new Edge(0, 3, 40));
    graph.get(3).add(new Edge(3, 0, 40));

    graph.get(0).add(new Edge(0, 1, 10));
    graph.get(1).add(new Edge(1, 0, 10));

    graph.get(1).add(new Edge(1, 2, 10));
    graph.get(2).add(new Edge(2, 1, 10));

    graph.get(2).add(new Edge(2, 3, 10));
    graph.get(3).add(new Edge(3, 2, 10));

    graph.get(3).add(new Edge(3, 4, 2));
    graph.get(4).add(new Edge(4, 3, 2));

    graph.get(4).add(new Edge(4, 5, 3));
    graph.get(5).add(new Edge(5, 4, 3));

    graph.get(4).add(new Edge(4, 6, 8));
    graph.get(6).add(new Edge(6, 4, 8));

    graph.get(5).add(new Edge(5, 6, 3));
    graph.get(6).add(new Edge(6, 5, 3));

    getMinSpanningTree(graph, 0);
  }
}
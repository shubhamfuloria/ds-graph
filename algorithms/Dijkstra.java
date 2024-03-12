package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Problem: A weighted graph is given, find shortest path form a given source to destination in terms of weight
 * 
 * The algorithm is simple, we use priority queue instead of queue in normal BFS algorithms. 
 * The priority queue will remove path with lower weight first
 * And that is how we get shortest path in terms of weight
 * 
 */
public class Dijkstra {

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
    String psf; // path so far
    int wsf; // weight so far

    Pair(int v, String psf, int wsf) {
      this.v = v;
      this.psf = psf;
      this.wsf = wsf;
    }

    public int compareTo(Pair to) {
      return this.wsf - to.wsf;
    }
  }

  public static void getShortestPath(List<List<Edge>> graph, int source, int dest) {

    PriorityQueue<Pair> pq = new PriorityQueue<>();

    pq.offer(new Pair(source, source + "", 0));
    boolean[] visited = new boolean[graph.size()];

    while (!pq.isEmpty()) {

      Pair pair = pq.poll();

      if (visited[pair.v] == true) {
        continue;
      }

      visited[pair.v] = true;

      System.out.println(pair.v + " via " + pair.psf + " @ " + pair.wsf);

      for (Edge edge : graph.get(pair.v)) {
        if (visited[edge.neighbour] == false) {
          pq.offer(new Pair(edge.neighbour, pair.psf + edge.neighbour, pair.wsf + edge.weight));
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

    getShortestPath(graph, 0, 6);
  }
}

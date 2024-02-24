// package traversal;

// import representation.Edge;
// import representation.AdjacencyList;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Program {

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

  /**
   * This will start from start node and keep digging to all nodes that can be
   * reachable from
   * start and simultaneously marks them as visited
   * An interative loop is running in caller function of this, which can then
   * easily count
   * connected components
   * 
   * @param graph
   * @param start
   * @param visited
   */
  public static void getConnectedComponents(List<List<Edge>> graph, int start, boolean[] visited) {

    visited[start] = true;

    for (Edge edge : graph.get(start)) {
      if (visited[edge.neighbour] == false) {
        getConnectedComponents(graph, edge.neighbour, visited);
      }
    }
  }

  public static void main(String[] args) {
    boolean[] visited = new boolean[7];
    int start = 0;

    // dfs(graph.getList(), start, visited);
    // List<List<Edge>> graph = new (7).getGraph();

    List<List<Edge>> graph = new ArrayList<>();

    for (int i = 0; i < 7; i++) {
      graph.add(new ArrayList<>());
    }

    graph.get(0).add(new Edge(0, 1, 0));
    graph.get(1).add(new Edge(1, 0, 0));

    graph.get(2).add(new Edge(2, 3, 0));
    graph.get(3).add(new Edge(3, 2, 0));

    graph.get(4).add(new Edge(4, 5, 0));
    graph.get(5).add(new Edge(5, 4, 0));

    graph.get(4).add(new Edge(4, 6, 0));
    graph.get(6).add(new Edge(6, 4, 0));

    graph.get(5).add(new Edge(5, 6, 0));
    graph.get(6).add(new Edge(6, 5, 0));

    int components = 0;
    for (int i = 0; i < 7; i++) {
      if (visited[i] == false) {
        getConnectedComponents(graph, i, visited);
        components++;
      }

    }

    System.out.println("Total Connected components are: " + components);
  }
}

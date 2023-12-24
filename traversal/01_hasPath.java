package traversal;

import java.util.List;

import representation.AdjacencyList;
import representation.Edge;

class DepthFirstSearch {

  public static void dfs(List<List<Edge>> graph, int curr, boolean[] visited) {
    if (visited[curr] == true) {
      return;
    }

    visited[curr] = true;
    System.err.println(curr);
    for (int i = 0; i < graph.get(curr).size(); i++) {
      dfs(graph, graph.get(curr).get(i).neighbour, visited);
    }
  }

  // this function checks if there is a path between vertex source and destination
  public static boolean hasPath(List<List<Edge>> graph, int source, int destination, boolean[] visited) {

    if (source == destination) {
      return true;
    }

    visited[source] = true;

    for (Edge edge : graph.get(source)) {
      if (visited[edge.neighbour] == false) {
        boolean has_path = hasPath(graph, edge.neighbour, destination, visited);
        if (has_path) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    boolean[] visited = new boolean[7];
    int start = 0;

    // dfs(graph.getList(), start, visited);
    List<List<Edge>> graph = new AdjacencyList(7).getGraph();
    boolean res = hasPath(graph, start, 6, visited);
    System.out.println(res);
  }
}

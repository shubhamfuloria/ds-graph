package traversal;

import java.util.List;
import java.util.ArrayList;

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

  // this function checks if there is a path vetween vertex source and destination
  public static boolean hasPath(List<List<Edge>> graph, int source, int destination, boolean[] visited) {

    if (source == destination) {
      return true;
    }

    visited[source] = true;

    // for (int i = 0; i < graph.get(source).size(); i++) {
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

  public static List<List<Integer>> getAllPaths(List<List<Edge>> graph, int source, int destination,
      boolean[] visited) {
    if (source == destination) {
      List<List<Integer>> res = new ArrayList<>();
      List<Integer> path = new ArrayList<>();
      path.add(source);
      res.add(path);
      return res;
    }

    visited[source] = true;

    List<List<Integer>> res = new ArrayList<>();
    for (Edge edge : graph.get(source)) {

      if (visited[edge.neighbour] == true) {
        continue;
      }
      List<List<Integer>> pathsFromNeighbour = getAllPaths(graph, edge.neighbour, destination, visited);

      for (List<Integer> path : pathsFromNeighbour) {
        path.add(0, source);
        res.add(path);
      }
    }

    // backtrack
    visited[source] = false;
    return res;
  }

  public static void main(String[] args) {

    AdjacencyList graph = new AdjacencyList(7);

    graph.addEdge(0, 3);
    graph.addEdge(0, 1);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    graph.addEdge(2, 4);
    graph.addEdge(3, 4);
    graph.addEdge(4, 5);
    graph.addEdge(4, 6);
    graph.addEdge(5, 6);

    // graph.print();

    boolean[] visited = new boolean[7];
    int start = 0;

    // dfs(graph.getList(), start, visited);

    // boolean res = hasPath(graph.getList(), start, 6, visited);
    // System.out.println(res);

    List<List<Integer>> paths = getAllPaths(graph.getList(), start, 6, visited);

    for (List<Integer> path : paths) {
      for (Integer vertex : path) {
        System.out.print(vertex + " ");
      }
      System.out.println();
    }
  }
}

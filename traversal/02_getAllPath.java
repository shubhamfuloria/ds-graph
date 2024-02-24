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

  public static List<List<Integer>> getAllPaths(List<List<Edge>> graph, int source, int destination,
      boolean[] visited) {

    if (source == destination) {
      List<List<Integer>> res = new ArrayList<>();
      List<Integer> list = Arrays.asList(source);
      res.add(list);
      return res;
    }

    List<List<Integer>> allPaths = new ArrayList<>();
    visited[source] = true;

    for (Edge edge : graph.get(source)) {
      if (visited[edge.neighbour] == false) {
        List<List<Integer>> pathsFromNbrToDest = getAllPaths(graph, edge.neighbour, destination, visited);

        for (List<Integer> path : pathsFromNbrToDest) {
          //add source to pathFromNbrToDest
          // so that we can get path from source to dest
          List<Integer> updatedPath = new ArrayList<>(path);
          updatedPath.add(0, source);
          allPaths.add(updatedPath);
        }
      }
    }
    visited[source] = false;
    return allPaths;
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

    graph.get(0).add(new Edge(0, 3, 0));
    graph.get(3).add(new Edge(3, 0, 0));

    graph.get(0).add(new Edge(0, 1, 0));
    graph.get(1).add(new Edge(1, 0, 0));

    graph.get(1).add(new Edge(1, 2, 0));
    graph.get(2).add(new Edge(2, 1, 0));

    graph.get(2).add(new Edge(2, 3, 0));
    graph.get(3).add(new Edge(3, 2, 0));

    graph.get(3).add(new Edge(3, 4, 0));
    graph.get(4).add(new Edge(4, 3, 0));

    graph.get(4).add(new Edge(4, 5, 0));
    graph.get(5).add(new Edge(5, 4, 0));

    graph.get(4).add(new Edge(4, 6, 0));
    graph.get(6).add(new Edge(6, 4, 0));

    graph.get(5).add(new Edge(5, 6, 0));
    graph.get(6).add(new Edge(6, 5, 0));

    List<List<Integer>> res = getAllPaths(graph, start, 6, visited);

    for (List<Integer> path : res) {
      System.out.println(path);
    }
  }
}

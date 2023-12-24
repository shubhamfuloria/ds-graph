package representation;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {

  private int vertexCount;
  private List<List<Edge>> graph;

  public AdjacencyList(int vertexCount) {
    this.vertexCount = vertexCount;
    graph = new ArrayList<>();

    // create all vertex
    for (int i = 0; i < vertexCount; i++) {
      graph.add(new ArrayList<>());
    }
  }

  public void addEdge(int source, int destination, int weight) {
    graph.get(source).add(new Edge(source, destination, weight));
    graph.get(destination).add(new Edge(destination, source, weight));
  }

  public void addEdge(int source, int destination) {
    graph.get(source).add(new Edge(source, destination, 0));
    graph.get(destination).add(new Edge(destination, source, 0));
  }

  public List<List<Edge>> getList() {
    return graph;
  }

  public List<List<Edge>> getGraph() {
    AdjacencyList graph = new AdjacencyList(7);

    graph.addEdge(0, 3);
    graph.addEdge(0, 1);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    graph.addEdge(3, 4);
    graph.addEdge(4, 5);
    graph.addEdge(4, 6);
    graph.addEdge(5, 6);

    return graph.getList();
  }

  public void print() {

    for (int i = 0; i < graph.size(); i++) {
      System.out.print(i + "=> ");
      for (int j = 0; j < graph.get(i).size(); j++) {
        System.out.print(graph.get(i).get(j).neighbour + ", ");
      }
      System.out.println();
    }
  }

  // public static void main(String[] args) {

  // GraphAdjacenyList graph = new GraphAdjacenyList(7);

  // graph.addEdge(0, 1);
  // graph.addEdge(0, 3);

  // graph.addEdge(1, 2);
  // graph.addEdge(2, 3);

  // graph.addEdge(3, 4);

  // graph.addEdge(4, 5);

  // graph.addEdge(4, 6);

  // graph.addEdge(5, 6);

  // graph.print();
  // }

  // print graph

}

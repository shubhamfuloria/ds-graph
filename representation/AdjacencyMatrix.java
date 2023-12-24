package representation;

class AdjacencyMatrix {
  private boolean adjacencyMatrix[][];
  private int vertexCount;

  public AdjacencyMatrix(int vertexCount) {
    this.vertexCount = vertexCount;
    adjacencyMatrix = new boolean[vertexCount + 1][vertexCount + 1];
  }

  public void addEdge(int source, int destination) {
    if (source < 0 || destination < 0 || source > vertexCount || destination > vertexCount) {
      System.out.println("Invalid indices: " + source + " " + destination + "");
      return;
    }
    adjacencyMatrix[source][destination] = true;
    adjacencyMatrix[destination][source] = true;
  }

  public void removeEdge(int source, int destination) {
    if (source < 0 || destination < 0 || source > vertexCount || destination > vertexCount) {
      System.out.println("Invalid indices");
      return;
    }
    adjacencyMatrix[source][destination] = false;
    adjacencyMatrix[destination][source] = false;
  }

  public boolean isEdge(int source, int destination) {
    if (source < 0 || destination < 0 || source > vertexCount || destination > vertexCount) {
      System.out.println("Invalid indices");
      return false;
    }
    return adjacencyMatrix[source][destination];
  }

  public void print() {

    for (int i = 0; i < adjacencyMatrix.length; i++) {
      System.out.print(i + "-> ");
      for (int j = 0; j < adjacencyMatrix[i].length; j++) {
        System.out.print(adjacencyMatrix[i][j] + " ");
      }
      System.err.println();
    }
  }

  // public static void main(String[] args) {

  // GraphAdjacecyMatrix graph = new GraphAdjacecyMatrix(5);
  // graph.addEdge(1, 2);
  // graph.addEdge(1, 4);

  // graph.addEdge(2, 5);
  // graph.addEdge(2, 4);

  // graph.addEdge(3, 4);

  // graph.print();
  // }
}
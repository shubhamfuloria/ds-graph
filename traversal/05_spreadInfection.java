import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.HashMap;

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
   * 
   * @param graph A Group of people
   * @param time
   * @return Initially 0th people is affected of COVID, and in 0 unit of time
   *         COVID gets spread to all
   *         direct neighbours of affected person. Returns no of people affected
   *         by COVID in time time
   */
  public static int spreadInfection(List<List<Edge>> graph, int time) {

    int patients_count = 1;
    int curr_time = 0;
    ArrayDeque<Integer> queue = new ArrayDeque<>();

    queue.offer(0);
    boolean[] visited = new boolean[graph.size()];
    while (queue.isEmpty() == false) {

      // remove mark* work add*

      int element = queue.poll();

      if (visited[element] == true) {
        continue;
      }
      visited[element] = true;

      patients_count++;
      curr_time++;

      for (Edge edge : graph.get(element)) {

        if (visited[edge.neighbour] == false) {
          queue.offer(edge.neighbour);
        }

      }
      if (curr_time == time) {
        return patients_count;
      }
    }

    return patients_count;
  }

  public static void main(String[] args) {
    int start = 0;
    int end = 6;
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

    int noOfPatients = spreadInfection(graph, 10);
    System.out.println("No of patients: " + noOfPatients);
  }
}
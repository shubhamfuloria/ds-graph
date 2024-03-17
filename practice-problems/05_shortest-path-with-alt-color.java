import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayDeque;

/*
 * This problem a bit special, we need to take 
 * 
 */

class Solution {

  public static class Edge {
    int src;
    int neighbour;
    char color;

    Edge(int src, int neighbour, char color) {
      this.src = src;
      this.neighbour = neighbour;
      this.color = color;
    }
  }

  public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
    /*
     * 1. Create Adjecenly list with edge color
     * 2. Apply BFS with alternate color
     * 3. Submit
     *
     *
     * //1
     *
     *
     */

    // 1
    List<List<Edge>> graph = new ArrayList<>(n);

    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int[] edge : redEdges) {
      // there is an edge from edge[0] to edge[1]
      int source = edge[0];
      int dest = edge[1];
      graph.get(edge[0]).add(new Edge(source, dest, 'R'));
    }

    for (int[] edge : blueEdges) {
      // there is an edge from edge[0] to edge[1]
      int source = edge[0];
      int dest = edge[1];
      graph.get(edge[0]).add(new Edge(source, dest, 'B'));
    }

    // start BFS

    ArrayDeque<Integer> vQueue = new ArrayDeque<>();
    ArrayDeque<Character> cQueue = new ArrayDeque<>();

    int steps = 0;

    int[] res = new int[n];
    Arrays.fill(res, -1);
    res[0] = 0;

    boolean[][] visited = new boolean[n][2];
    System.out.println();

    // we need to start exploring from 0 vertex
    vQueue.offer(0);
    cQueue.offer(' ');

    while (!vQueue.isEmpty()) {
      int size = vQueue.size();

      for (int i = 0; i < size; i++) {
        int vertex = vQueue.poll();
        char vColor = cQueue.poll();

        int colorIndex = vColor == 'R' ? 0 : 1;

        if (vColor != ' ' && visited[vertex][colorIndex] == true) {
          continue;
        }
        if (vColor != ' ') {
          visited[vertex][colorIndex] = true;
        }
        // visited[vertex] = true;
        if (vColor != ' ' && res[vertex] == -1) {
          res[vertex] = steps;
        }
        for (Edge edge : graph.get(vertex)) {
          if (visited[edge.neighbour][edge.color == 'R' ? 0 : 1] == false && edge.color != vColor) {
            vQueue.offer(edge.neighbour);
            cQueue.offer(edge.color);
          }
        }
      }

      steps++;
    }
    return res;
  }

  public static void main(String[] args) {
    // [[0,1],[1,2]]

    int[][] red = { { 0, 1 } };
    int[][] blue = { { 2, 1 } };
    int[] res = shortestAlternatingPaths(3, red, blue);

    for (int e : res) {
      System.out.println(e + " ");
    }
  }
}

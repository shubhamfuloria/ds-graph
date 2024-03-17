//https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/?envType=study-plan-v2&envId=graph-theory

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
  public static int minReorder(int n, int[][] connections) {

    // city -> destination, isPresent (0, 1)
    List<List<int[]>> graph = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int[] edge : connections) {
      int src = edge[0];
      int dest = edge[1];

      graph.get(src).add(new int[] { dest, 1 });
      graph.get(dest).add(new int[] { src, 0 });
    }

    Queue<int[]> queue = new LinkedList<>();
    boolean[] visited = new boolean[graph.size()];
    int reorder_count = 0;

    queue.offer(new int[] { 0, -1 });
    while (queue.isEmpty() == false) {

      int[] rem = queue.poll();

      int city = rem[0];
      int is_path_present = rem[1];

      if (visited[city] == true) {
        continue;
      }

      visited[city] = true;

      // we are coming to this city from 0 city
      // but we need path to 0 city

      if (is_path_present == 1) {
        // mean there is a path from 0 to this city
        // so we need to reverse this path in order to visit from this city to 0
        reorder_count++;
      }

      for (int[] nbr : graph.get(city)) {
        if (visited[nbr[0]] == false) {
          queue.offer(nbr);
        }
      }
    }
    return reorder_count;
  }

  public static void main(String[] args) {
    // int[][] connections = { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } };
    int[][] connections = { { 1, 0 }, { 1, 2 }, { 3, 2 }, { 3, 4 } };
    // n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
    int res = minReorder(5, connections);

    System.out.println(res);
  }
}
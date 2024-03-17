import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
  public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

    List<List<Integer>> graph = new ArrayList<>(n);

    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    // create graph
    for (int i = 0; i < manager.length; i++) {
      int m = manager[i];
      int emp = i;

      if (m == -1) {
        continue;
      }

      graph.get(m).add(emp);
    }

    // n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
    /*
     * 0 -> []
     * 1 -> []
     * 2 -> [0, 1, 3, 4, 5]
     * 3 -> []
     * 4 -> []
     * 5 -> []
     */

    // bfs
    // [employee, time so far]
    Queue<int[]> queue = new LinkedList<>();
    boolean[] visited = new boolean[graph.size()];

    int time = 0;

    queue.offer(new int[] { headID, 0 });

    while (queue.isEmpty() == false) {

      int[] rem = queue.poll();
      int emp = rem[0];
      int time_so_far = rem[1];

      if (visited[emp] == true) {
        continue;
      }

      visited[emp] = true;

      time = Math.max(time_so_far, time);
      for (int nbr : graph.get(emp)) {
        if (visited[nbr] == false) {
          queue.offer(new int[] { nbr, time_so_far + informTime[emp] });
        }
      }
    }
    return time;

    // start BFS
    // Queue<Integer>
  }

  public static void main(String[] args) {
    // int[] manager = { 2, 2, -1, 2, 2, 2 };
    // int[] informTime = { 0, 0, 1, 0, 0, 0 };
    int[] manager = { 2, 2, -1, 2, 2, 2, 0, 6, 1, 8, 8, 3 };
    int[] informTime = { 2, 3, 1, 1, 0, 0, 2, 2, 0, 2, 2, 5 };

    int res = numOfMinutes(12, 2, manager, informTime);
    System.out.println(res);
  }
}
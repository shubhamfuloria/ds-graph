import java.util.List;

/**
 * https://leetcode.com/problems/keys-and-rooms/description/
 * 
 * 
 * This is a simple pattern based problem which is based on connected
 * components.
 */
class Solution {
  public static void explore(List<List<Integer>> graph, int source, boolean[] visited) {

    if (visited[source] == true) {
      return;
    }

    visited[source] = true;

    // explore all neighours
    for (int nbr : graph.get(source)) {
      if (visited[nbr] == false) {
        explore(graph, nbr, visited);
      }
    }
  }

  // if there are more than one components of graph, then we can not visit that
  // room
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {

    int count = 0; // component count
    boolean[] visited = new boolean[rooms.size()];

    for (int i = 0; i < rooms.size(); i++) {
      explore(rooms, i, visited);
      count++;

      if (count > 1) {
        return false;
      }
    }
    return true;
  }
}
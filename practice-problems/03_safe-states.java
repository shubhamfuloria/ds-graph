import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

class Solution {

  public static boolean isEndInTerminalNode(int[][] graph, int source, boolean[] visited, Set<Integer> terminalNodes,
      int[] cache) {

    if (terminalNodes.contains(source)) {
      return true;
    }

    if (visited[source] == true) {
      return false;
    }

    visited[source] = true;

    // if there all the paths from all neighbours ends to terminal node, that means
    // source will also ends to terminal node

    for (int i = 0; i < graph[source].length; i++) {
      // if it's already visited then that means it's a cycle

      int neighbour = graph[source][i];
      if (visited[neighbour] == true) {
        return false;
      }

      if (cache[neighbour] != -1) {
        return cache[neighbour] == 0 ? false : true;
      }
      boolean isSafeNode = isEndInTerminalNode(graph, neighbour, visited, terminalNodes, cache);
      if (!isSafeNode) {
        cache[neighbour] = 0;
        return false;
      }
    }

    visited[source] = false;

    cache[source] = 1;
    return true;
  }

  public static List<Integer> eventualSafeNodes(int[][] graph) {

    // find terminal nodes
    boolean[] visited = new boolean[graph.length];

    Set<Integer> set = new HashSet<>();

    for (int i = 0; i < graph.length; i++) {
      if (graph[i].length == 0) {
        set.add(i);
      }
    }
    int[] cache = new int[graph.length];

    Arrays.fill(cache, -1);
    List<Integer> res = new ArrayList<>();

    for (int i = 0; i < graph.length; i++) {
      boolean r = isEndInTerminalNode(graph, i, visited, set, cache);

      if (r) {
        res.add(i);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[][] graph = {
        { 1, 2 },
        { 2, 3 },
        { 5 },
        { 0 },
        { 5 },
        {},
        {}
    };

    List<Integer> res = eventualSafeNodes(graph);
    System.out.println(res);
  }
}
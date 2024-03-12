class Solution {
  // this is classic example of DFS in grid
  private void dfs(int[][] graph, int source, boolean[] visited) {

    if (visited[source] == true) {
      return;
    }

    visited[source] = true;

    // add all neighbours of source
    for (int i = 0; i < graph.length; i++) {
      if (graph[source][i] == 1 && source != i && visited[i] == false) {
        dfs(graph, i, visited);
      }
    }
  }

  public int findCircleNum(int[][] isConnected) {

    boolean[] visited = new boolean[isConnected.length];
    int count = 0;
    for (int i = 0; i < isConnected.length; i++) {
      if (visited[i] == false) {
        dfs(isConnected, i, visited);
        count++;
      }
    }
    return count;
  }
}
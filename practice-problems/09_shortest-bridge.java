import java.util.LinkedList;
import java.util.Queue;

class Solution {

  /*
   * This will return shortest path from (row, col) cell to desitnation using BFS
   */
  private int getShortestPath(int[][] grid, int row, int col, int destination) {

    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[grid.length][grid.length];
    int steps = 0;

    queue.add(new int[] { row, col });

    while (queue.isEmpty() == false) {

      int size = queue.size();
      for (int i = 0; i < size; i++) {

        int[] curr_cell = queue.poll();

        int c_row = curr_cell[0];
        int c_col = curr_cell[1];

        if (visited[c_row][c_col] == true) {
          continue;
        }

        visited[c_row][c_col] = true;

        if (grid[c_row][c_col] == destination) {
          return steps;
        }

        // add neighbours
        int[] row_dir = { -1, 0, 1, 0 };
        int[] col_dir = { 0, 1, 0, -1 };

        for (int ii = 0; ii < 4; ii++) {
          int n_row = c_row + row_dir[ii];
          int n_col = c_col + col_dir[ii];

          if (n_row >= 0 && n_col >= 0 && n_row < grid.length && n_col < grid.length) {

            if (visited[n_row][n_col] == false && grid[n_row][n_col] != 2) {
              queue.add(new int[] { n_row, n_col });
            }
          }
        }

      }
      steps++;
    }

    return -1;
  }

  private void dfs(int[][] grid, int row, int col, boolean[][] visited, int mark) {

    if (visited[row][col] == true) {
      return;
    }

    visited[row][col] = true;
    grid[row][col] = mark;

    int[] row_dir = { -1, 0, 1, 0 };
    int[] col_dir = { 0, 1, 0, -1 };

    for (int i = 0; i < 4; i++) {

      // vertex should be visitable
      int next_row = row + row_dir[i];
      int next_col = col + col_dir[i];

      // vertext should be inside grid
      if (next_row >= 0 && next_col >= 0 && next_row < grid.length && next_col < grid.length) {

        // vertex should not be water and should not yet visited
        if (visited[next_row][next_col] == false && grid[next_row][next_col] != 0) {
          dfs(grid, next_row, next_col, visited, mark);
        }
      }
    }

  }

  public int shortestBridge(int[][] grid) {

    /*
     * ALGORITHM
     * 
     * 1. mark first island with 2
     * 2. mark secodn island with 3
     * 3. find shortest path from all vertex of first island to island 3
     * 4. return the minimum
     */

    // marking islands with 2 and 3
    int mark = 2;
    boolean[][] visited = new boolean[grid.length][grid.length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {

        if (visited[i][j] == false && grid[i][j] == 1) {

          // this call will mark all vertex of 1st island as 2
          dfs(grid, i, j, visited, mark);

          // in next iteration mark will be 3, so 2nd island will be marked as 3
          mark = 3;
        }
      }
    }

    // finding shortest path
    int shortest_path = Integer.MAX_VALUE;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {

        if (grid[i][j] == 2) {
          // we are at a vertex of island 1
          int path = getShortestPath(grid, i, j, 3);
          shortest_path = path == -1 ? shortest_path : Math.min(shortest_path, path);
        }

      }
    }
    return shortest_path - 1;
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    // int[][] grid = {
    // { 1, 1, 1, 1, 1 },
    // { 1, 0, 0, 0, 1 },
    // { 1, 0, 1, 0, 1 },
    // { 1, 0, 0, 0, 1 },
    // { 1, 1, 1, 1, 1 }
    // };

    int[][] grid = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };

    int s_path = s.shortestBridge(grid);

    for (int[] row : grid) {
      for (int col : row) {
        System.err.print(col + " ");
      }
      System.out.println();
    }

    System.err.println("Shortest path is: " + s_path);

  }
}
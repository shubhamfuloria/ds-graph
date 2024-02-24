class Solution {
  private void dfs(char[][] grid, int sRow, int sCol, boolean[][] visited) {

    // sRow and sCol should be valid indices
    if (sRow < 0 || sCol < 0 || sRow >= grid.length || sCol >= grid[sRow].length) {
      return;
    }
    // current index should be non visited land
    if (visited[sRow][sCol] == true || grid[sRow][sCol] == '0') {
      return;
    }

    visited[sRow][sCol] = true;

    // move in four directions
    int[] rows = { -1, 0, 1, 0 };
    int[] cols = { 0, 1, 0, -1 };

    for (int i = 0; i < 4; i++) {
      dfs(grid, sRow + rows[i], sCol + cols[i], visited);
    }
  }

  public int numIslands(char[][] grid) {

    boolean[][] visited = new boolean[grid.length][grid[0].length];
    int noOfIsland = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (visited[i][j] == false && grid[i][j] == '1') {
          noOfIsland++;
          dfs(grid, i, j, visited);
        }
      }
    }

    return noOfIsland;
  }
}

class Program {
  public static void main(String[] args) {
    Solution s = new Solution();

    char[][] grid = {
        { '1', '1', '1', '1', '0' },
        { '1', '1', '0', '1', '0' },
        { '1', '1', '0', '0', '0' },
        { '0', '0', '0', '0', '0' }
    };

    int res = s.numIslands(grid);

    System.out.println("no of island: " + res);
  }
}

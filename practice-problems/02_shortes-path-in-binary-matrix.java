import java.util.ArrayDeque;

class Solution {
  public static int shortestPathBinaryMatrix(int[][] grid) {

    if (grid[0][0] == 1) {
      return -1;
    }

    ArrayDeque<Integer> rqueue = new ArrayDeque<>();
    ArrayDeque<Integer> cqueue = new ArrayDeque<>();

    // initially we are at top left corner (0, 0)
    rqueue.offer(0);
    cqueue.offer(0);

    // direction vectors
    int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
    int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

    int levels = 0;

    boolean[][] visited = new boolean[grid.length][grid[0].length];

    while (rqueue.isEmpty() == false || cqueue.isEmpty() == false) {

      int size = rqueue.size();

      for (int k = 0; k < size; k++) {
        int row = rqueue.poll();
        int col = cqueue.poll();

        // cell should not be visited
        if (visited[row][col] == true) {
          continue;
        }

        // is it our destination ?
        if (row == grid.length - 1 && col == grid[0].length - 1 && grid[row][col] == 0) {
          return levels + 1;
        }

        visited[row][col] = true;
        // levels++;

        for (int i = 0; i < 8; i++) {
          int nr = row + dr[i];
          int nc = col + dc[i];

          // is it a valid cell ?
          if (nr < 0 || nc < 0 || nr > grid.length - 1 || nc > grid[0].length - 1) {
            continue;
          }

          // is it visitable cell ?
          if (grid[nr][nc] == 1) {
            continue;
          }

          if (visited[nr][nc] == false) {
            rqueue.offer(nr);
            cqueue.offer(nc);
          }
        }
      }
      levels++;
    }
    return -1;
  }

  public static void main(String[] args) {
    // [[1,0,0],[1,1,0],[1,1,0]]
    int[][] grid = {
        { 1, 0, 0 },
        { 1, 1, 0 },
        { 1, 1, 0 }
    };

    int res = shortestPathBinaryMatrix(grid);
    System.out.println(res);
  }
}
import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int nearestExit(char[][] maze, int[] entrance) {

    // [row, col]
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[maze.length][maze[0].length];

    // initially we are at entrace
    queue.offer(entrance);
    int steps = 0;

    int[] row_dir = { -1, 0, 1, 0 };
    int[] col_dir = { 0, 1, 0, -1 };

    while (queue.isEmpty() == false) {

      int size = queue.size();

      for (int i = 0; i < size; i++) {
        int[] current_cell = queue.poll();

        int row = current_cell[0];
        int col = current_cell[1];

        if (visited[row][col] == true) {
          continue;
        }

        visited[row][col] = true;

        // check if it's an exit

        // entrance can not be exit
        if (row != entrance[0] || col != entrance[1]) {

          if (row == 0 || col == 0 || row == maze.length - 1 || col == maze[0].length - 1) {
            return steps;
          }
        }

        // add neighbours
        for (int ii = 0; ii < 4; ii++) {
          int nbr_row = row + row_dir[ii];
          int nbr_col = col + col_dir[ii];

          if (nbr_row >= 0 && nbr_row < maze.length && nbr_col >= 0 && nbr_col < maze[0].length) {
            // cell should be visitable
            if (maze[nbr_row][nbr_col] == '.') {
              // cell should not be already visited
              if (visited[nbr_row][nbr_col] == false) {
                queue.offer(new int[] { nbr_row, nbr_col });
              }
            }
          }
        }
      }
      steps++;
    }
    return -1;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    // [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]]
    char[][] maze = {
        { '+', '+', '.', '+' },
        { '.', '.', '.', '+' },
        { '+', '+', '+', '.' }
    };

    int res = s.nearestExit(maze, new int[] { 1, 2 });
    System.out.println(res);
  }
}

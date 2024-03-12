class Solution {
  public boolean judgeCircle(String moves) {

    int x = 0;
    int y = 0;

    // for (char c : moves) {
    for (int i = 0; i < moves.length(); i++) {
      char c = moves.charAt(i);
      switch (c) {
        case 'D':
          y--;
          break;
        case 'U':
          y++;
          break;
        case 'L':
          x--;
          break;
        case 'R':
          x++;
          break;
      }
    }
    return x == 0 && y == 0;
  }
}
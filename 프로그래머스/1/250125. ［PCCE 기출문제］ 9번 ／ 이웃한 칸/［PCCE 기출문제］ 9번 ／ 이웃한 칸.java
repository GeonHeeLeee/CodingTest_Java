import java.util.*;
class Solution {
    public int solution(String[][] board, int h, int w) {
        int count = 0;
        int height = board.length;
        int width = board[0].length;
        int[] dy = {0, 1, -1, 0};
        int[] dx = {1, 0, 0, -1};
        String color = board[h][w];
        for(int x = 0; x < 4; x ++) {
            if(h + dy[x] < height && w + dx[x] < width && h + dy[x] >= 0 && w + dx[x] >=0) {
                if(board[h + dy[x]][w + dx[x]].equals(color)) {
                    count += 1;
                }
            }
        }
        return count;
    }
}
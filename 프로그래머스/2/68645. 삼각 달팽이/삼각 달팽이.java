import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[][] snail = new int[n][n];
        int[][] dir = new int[][]{{1,0},{0,1},{-1,-1}};
        int y = 0;
        int x = 0;
        int index = 1;
        for(int i = 0; i <= n; i ++) {
            while(y >= i/3 && y < n - i/3 && x >= i/3 && x < n - i/3 && snail[y][x] == 0) {
                snail[y][x] = index ++;
                y += dir[i % 3][0];
                x += dir[i % 3][1];
            }

            y -= dir[i % 3][0];
            x -= dir[i % 3][1];
            
            y += dir[(i+1)%3][0];
            x += dir[(i+1)%3][1];
        }

        return Arrays.stream(snail).flatMapToInt(Arrays::stream).filter(i -> i != 0).toArray();
    }
}
 
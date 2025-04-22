import java.util.*;
class Solution {
    static final int ATTACK = 1;
    static final int HEAL = 2;
    
    public int solution(int[][] board, int[][] skills) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] diff = new int[n + 1][m + 1];
        
        for(int[] skill : skills) {
            int type = skill[0];
            int r1 = skill[1];
            int c1 = skill[2];
            int r2 = skill[3];
            int c2 = skill[4];
            int degree = skill[5];
            
            if(type == ATTACK) {
                degree = - degree;
            }
            
            diff[r1][c1] += degree;
            diff[r1][c2 + 1] -= degree;
            diff[r2 + 1][c1] -= degree;
            diff[r2 + 1][c2 + 1] += degree;
        }
        
        for(int r = 0; r < n; r ++) {
            for(int c = 1; c < m; c ++) {
                diff[r][c] += diff[r][c - 1];
            }
        }
        for(int r = 1; r < n; r ++) {
            for(int c = 0; c < m; c ++) {
                diff[r][c] += diff[r - 1][c];
            }
        }
        
        for(int r = 0; r < n; r ++) {
            for(int c = 0; c < m; c ++) {
                if(board[r][c] + diff[r][c] > 0) {
                    answer ++;
                }
            }
        }
        
        return answer;
    }
}
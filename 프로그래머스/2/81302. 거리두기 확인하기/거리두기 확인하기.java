
import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer, 1);
        for(int a = 0; a < 5; a ++) {
            boolean flag = false;
            for(int i = 0; i < 5; i ++) {
                for(int j = 0; j < 5; j ++) {
                    char letter = places[a][i].charAt(j);
                    if(letter == 'P' && isNear(places[a], i, j)) {
                        flag = true;
                        break;
                    }
                }
                if(flag) {
                    break;
                }
            }
            if(flag) {
                answer[a] = 0;
            }
        }

        return answer;
    }
    
    public boolean isNear(String[] places, int y, int x) {
        int[][] dir1 = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int[][] dir2 = new int[][]{{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int i = 0; i < 4; i ++) {
            int dy = y + dir1[i][0];
            int dx = x + dir1[i][1];
            if(dy >= 0 && dy < 5 && dx >= 0 && dx < 5 && places[dy].charAt(dx) == 'P') {
                return true;
            }
        }
        for(int i = 0; i < 4; i ++) {
            int dy = y + dir2[i][0];
            int dx = x + dir2[i][1];
            if(dy >= 0 && dy < 5 && dx >= 0 && dx < 5 && places[dy].charAt(dx) == 'P') {
                if(places[dy-dir2[i][0]].charAt(dx) != 'X' || places[dy].charAt(dx-dir2[i][1]) != 'X') {
                    return true;
                }
            }
        }
        for(int i = 0; i < 4; i ++) {
            int dy = y + dir1[i][0] * 2;
            int dx = x + dir1[i][1] * 2;
            if(dy >= 0 && dy < 5 && dx >= 0 && dx < 5 && places[dy].charAt(dx) == 'P') {
                if(places[y + dir1[i][0]].charAt(x + dir1[i][1]) != 'X') {
                    return true;
                }
            }
        }
        return false;
    }
}
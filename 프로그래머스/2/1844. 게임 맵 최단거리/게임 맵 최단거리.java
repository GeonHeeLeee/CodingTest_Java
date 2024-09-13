import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[][] direction = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        return bfs(maps, direction);
    }
    public int bfs(int[][] maps, int[][] direction) {
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> queue = new LinkedList();
        
        queue.add(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int step = current[2];
            
            for(int[] dir : direction) {
                int nRow = dir[0] + row;
                int nCol = dir[1] + col;
                
                if(nRow == m-1 && nCol ==n-1) {
                    return step + 1;
                }
                if(nRow >= 0 && nCol >= 0 && nRow < m && nCol < n && !visited[nCol][nRow] && maps[nCol][nRow] == 1) {
                    queue.add(new int[]{nRow, nCol, step + 1});
                    visited[nCol][nRow] = true;
                }
            }
        }
        return - 1;
    }
}
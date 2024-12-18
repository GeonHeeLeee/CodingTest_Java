import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList();
        int[][] dir = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] location = queue.poll();
            int y = location[0];
            int x = location[1];
            int count = location[2];
            
            for(int idx = 0; idx < dir.length; idx ++) {
                int dy = y + dir[idx][0];
                int dx = x + dir[idx][1];
                
                if(dy >= 0 && dx >= 0 && dy < maps.length && dx < maps[0].length && !visited[dy][dx] && maps[dy][dx] == 1) {
                    queue.offer(new int[]{dy, dx, count + 1});
                    visited[dy][dx] = true;
                }
                if(dy == maps.length - 1 && dx == maps[0].length - 1) {
                    return count + 1;
                }
            }
        }
        return -1;
    }
}
import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        boolean[] visited = new boolean[y+1];
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{x, 0});
        visited[x] = true;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int count = current[1];
            
            if(curX == y) {
                return count;
            }
            
            int[] nextValue = new int[]{curX + n, curX * 2, curX * 3};
            
            for(int next : nextValue) {
                if(next <= y && !visited[next]) {
                    queue.add(new int[]{next, count + 1});
                    visited[next] = true;
                }
            }
        }
        return -1;
    }
}
import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i ++) {
            if(!visited[i]) {
                dfs(n, computers, i, visited);
                answer ++;
            }
        }
        return answer;
    }
    public void dfs(int n, int[][] computers, int current, boolean[] visited) {
        visited[current] = true;
        
        for(int col = 0; col < n; col ++) {
            if(computers[current][col] == 1 && !visited[col]) {
                dfs(n, computers, col, visited);
            }
        }
    }
}
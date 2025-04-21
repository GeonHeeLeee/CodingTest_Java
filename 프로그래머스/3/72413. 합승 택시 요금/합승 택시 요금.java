import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dist = new int[n + 1][n + 1];
        int INF = 210 * 100000;
        for(int i = 1; i <= n; i ++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        
        for(int[] fare : fares) {
            int start = fare[0];
            int dest = fare[1];
            int cost = fare[2];
            
            dist[start][dest] = cost;
            dist[dest][start] = cost;
        }
        
        
        for(int k = 1; k <= n; k ++) {
            for(int i = 1; i <= n; i ++) {
                for(int j = 1; j <= n; j ++) {
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }
        
        int answer = dist[s][a] + dist[s][b];
        for(int k = 1; k <= n; k ++) {
            int cost = dist[s][k] + dist[k][a] + dist[k][b];
            answer = Math.min(cost, answer);
        }
        return answer;
    }
}
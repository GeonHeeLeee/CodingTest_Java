import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        dfs(dungeons, k, 0, new boolean[dungeons.length]);
        return answer;
    }
    public void dfs(int[][] dungeons, int k, int count, boolean[] visited) {
        answer = Math.max(answer, count);
        for(int idx = 0; idx < dungeons.length; idx ++)  {
            int minFatigue = dungeons[idx][0];
            int requiredFatigue = dungeons[idx][1];
            if(!visited[idx] && k >= minFatigue) {
                visited[idx] = true;
                dfs(dungeons, k - requiredFatigue, count + 1, visited);
                visited[idx] = false;
            }
        }
    }
}
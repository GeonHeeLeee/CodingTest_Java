class Solution {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        explore(k, dungeons, new boolean[dungeons.length], 0);
        return answer;
    }
    
    public void explore(int k,int[][] dungeons, boolean[] visited, int count) {
        answer = Math.max(answer, count);
        
        for(int i = 0; i < dungeons.length; i ++) {
            int required = dungeons[i][0];
            int used = dungeons[i][1];
            
            if(!visited[i] && required <= k) {
                visited[i] = true;
                explore(k - used, dungeons, visited, count + 1);
                visited[i] = false;
            }
        }
    }
}
class Solution {
    int answer = Integer.MIN_VALUE;
    public int solution(int k, int[][] dungeons) {
        exploreDungeons(k, dungeons, new boolean[dungeons.length], 0);
        return answer;
    }
    
    public void exploreDungeons(int curK, int[][] dungeons, boolean[] visited, int count) {
        answer = Math.max(answer, count);
        
        for(int i = 0; i < dungeons.length; i ++) {
            int required = dungeons[i][0];
            int used = dungeons[i][1];
            
            if(!visited[i] && required <= curK) {
                visited[i] = true;
                exploreDungeons(curK - used, dungeons, visited, count + 1);
                visited[i] = false;
            }
        }
    }
}
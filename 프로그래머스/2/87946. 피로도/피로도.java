class Solution {
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        return backTrack(dungeons, visited, 0, k);
    }
    public int backTrack(int[][] dungeons, boolean[] visited, int count, int fatigue) {
        int maxCount = count;
        
        for(int i = 0; i < dungeons.length; i ++) {
            int minHealth = dungeons[i][0];
            int needHealth = dungeons[i][1];
            
            if(!visited[i] && fatigue >= minHealth) {
                visited[i] = true;
                maxCount = Math.max(maxCount, backTrack(dungeons, visited, count + 1, fatigue - needHealth));
                visited[i] = false;
            }
        }
        return maxCount;
    }
}
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = dfs(target, words, begin, 0, new boolean[words.length]);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    public int dfs(String target, String[] words, String current, int count, boolean[] visited) {
        if(current.equals(target)) {
            return count;
        }
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i ++) {
            if(!visited[i] && isSimilar(words[i], current)) {
                visited[i] = true;
                int result = dfs(target, words, words[i], count + 1, visited);
                minValue = Math.min(minValue, result);
                visited[i] = false;
            }
        }
        return minValue;
    }
    public boolean isSimilar(String s1, String s2) {
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        int diffCount = 0;
        for(int i = 0; i < char1.length; i ++) {
            if(char1[i] != char2[i]) {
                diffCount ++;
                if(diffCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
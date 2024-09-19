class Solution {
    static int answer = 0;
    static String alpha = "AEIOU";
    static int cnt = 0;
    static String[] dict = alpha.split("");
    public int solution(String word) {
        StringBuilder sb = new StringBuilder();
        dfs(word, 0, sb);
        return answer;
    }
    public void dfs(String target, int count, StringBuilder sb) {
        if(sb.toString().equals(target)) {
            answer = cnt;
            return;
        }
        if(count == 5) {
            return;
        }
        for(int i = 0; i < dict.length; i ++) {
            sb.append(dict[i]);
            cnt ++;
            dfs(target, count + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            if(answer > 0) {
                return;
            }
        }
    }
}
class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            answer = Math.max(answer, expandAroundCenter(s, i, i));
            answer = Math.max(answer, expandAroundCenter(s, i, i + 1));
        }
        return answer;
    }

    public int expandAroundCenter(String s, int left, int right) {
        int length = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            length = right - left + 1;
            left--;
            right++;
        }
        return length;
    }
}

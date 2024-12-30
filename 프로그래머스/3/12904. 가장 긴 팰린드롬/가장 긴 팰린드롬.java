class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        for(int idx = 0; idx < s.length(); idx ++) {
            answer = Math.max(answer, expandAroundCenter(s, idx, idx));
            answer = Math.max(answer, expandAroundCenter(s, idx, idx + 1));
        }
        return answer;
    }
    
    public int expandAroundCenter(String s, int leftIdx, int rightIdx) {
        int length = 0;
        while(leftIdx >= 0 && rightIdx < s.length() && s.charAt(leftIdx) == s.charAt(rightIdx)) {
            length = rightIdx - leftIdx + 1;
            rightIdx ++;
            leftIdx --;
        }
        return length;
    }
}
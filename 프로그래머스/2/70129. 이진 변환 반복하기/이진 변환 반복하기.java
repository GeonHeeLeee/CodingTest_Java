class Solution {
    public int[] solution(String s) {
        int zeroCount = 0;
        int tryCount = 0;
        while(!s.equals("1")) {
            int orgSLength = s.length();
            s = s.replaceAll("0","");
            zeroCount += (orgSLength - s.length());
            tryCount ++;
            s = Integer.toBinaryString(s.length());
        }
        int[] answer = {tryCount, zeroCount};
        return answer;
    }
}
class Solution {
    public int solution(int n) {
        int answer = 0;
        int oneLength = Integer.bitCount(n);
        int biggerNum = n + 1;
        int oneCount = 0;
        while(true) {
            oneCount = Integer.bitCount(biggerNum);
            if(oneCount == oneLength) {
                answer = biggerNum;
                break;
            }
            biggerNum ++;
        }
        return answer;
    }
}
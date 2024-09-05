class Solution {
    public int solution(int n) {
        int answer = 0;
        int oneLength = Integer.bitCount(n);
        int biggerNum = n + 1;
        int oneCount = 0;
        while(true) {
            oneCount = Integer.bitCount(biggerNum); //bitCount는 정수를 2진수로 변환후 1의 개수를 세어준다.
            if(oneCount == oneLength) {
                answer = biggerNum;
                break;
            }
            biggerNum ++;
        }
        return answer;
    }
}
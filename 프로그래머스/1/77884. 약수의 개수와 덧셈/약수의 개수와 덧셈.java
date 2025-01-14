class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i ++) {
            int a = 0;
            for (int k = 1; k <= i; k ++) {
                if(i % k == 0) {
                    a += 1;
                }
            }
            if(a % 2 == 0)  {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }
}
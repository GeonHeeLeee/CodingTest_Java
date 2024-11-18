import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(n > s) {
            return new int[]{-1};
        }
        int div = s / n;
        int mod = s % n;
        Arrays.fill(answer, div);
        for(int i = 0; i < mod; i ++) {
            answer[n-i-1] += 1;
        }

        return answer;
    }
}
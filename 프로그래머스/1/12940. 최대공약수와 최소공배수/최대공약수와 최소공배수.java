import java.util.*;
class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {0,0};
        for(int i = 2; i <= n; i ++) {
            if(n % i == 0 && m % i == 0) {
                answer[0] = i;
            }
        }
        if(answer[0] == 0) {
            answer [0] = 1;
        }
        for(int i = m*n; i >=m; i --) {
            if(i % n == 0 && i % m == 0) {
                answer[1] = i;
            }
        }
        return answer;
    }
}
import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> numList = new ArrayList<>();
        long fac = 1;
        for(int i = 1; i <= n; i ++) {
            numList.add(i);
            fac *= i;
        }
        k --;
        for(int i = 0; i < n; i ++) {
            fac = fac / (n - i);
            answer[i] = numList.remove((int) (k / fac));
            k %= fac;
        }
        return answer;
    }
}
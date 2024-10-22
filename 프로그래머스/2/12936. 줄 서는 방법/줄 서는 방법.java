import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> people = new ArrayList();
        long fac = 1;
        for(int i = 1; i <= n; i ++) {
            fac *= i;
            people.add(i);
        }
        k --;
        for(int i = 0; i < n; i ++) {
            fac = fac / (n - i);
            int index = (int) (k / fac);
            answer[i] = people.remove(index);
            k = k % fac;
        }

        return answer;
    }
}
    


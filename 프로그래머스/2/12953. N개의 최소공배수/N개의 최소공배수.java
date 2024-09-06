import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int min = arr[0];
        for(int i = 1; i < arr.length; i ++) {
            for(int k = min; k >= 1; k --) {
                if(arr[i] % k == 0 && min % k == 0) {
                    answer = min * arr[i] / k;
                    min = answer;
                    break;
                }
            }

        }
        return answer;
    }
}
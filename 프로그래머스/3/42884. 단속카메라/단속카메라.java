import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a,b) -> Integer.compare(a[1], b[1]));
        int camera = Integer.MIN_VALUE;
        for(int[] route : routes) {
            if(route[0] > camera) {
                answer ++;
                camera = route[1];
            }
        }
        return answer;
    }
}

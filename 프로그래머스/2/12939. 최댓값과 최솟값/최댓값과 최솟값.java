import java.util.*;
class Solution {
    public String solution(String s) {
        int[] input = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i : input) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        return min + " " + max;
    }
}
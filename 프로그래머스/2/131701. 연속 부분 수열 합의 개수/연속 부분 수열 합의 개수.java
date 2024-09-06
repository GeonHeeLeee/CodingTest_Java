import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int[] input = new int[elements.length * 2 - 1];
        for(int i = 0; i < elements.length * 2 - 1; i ++) {
            input[i] = elements[i % elements.length];
        }

        Set<Integer> sumSet = new HashSet();
        for(int i = 1; i <= elements.length; i ++) {
            for(int k = 0; k < elements.length; k ++) {
                int sum = 0;
                for(int j = k; j < k + i; j ++) {
                    sum += input[j];
                }
                sumSet.add(sum);
            }
            
        }
        return sumSet.size();
    }
}
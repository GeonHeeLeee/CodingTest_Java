import java.util.*;
class Solution {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList();
        char[] input = s.toCharArray();
        for(int i = 0; i < input.length; i ++) {
            char letter = input[i];
            answer.add(-1);
            for(int k = 0; k < i; k ++) {
                if(letter == input[k]) {
                    answer.set(i, i-k);
                }
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}
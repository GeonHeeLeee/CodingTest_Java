import java.util.stream.*;
import java.util.*;
class Solution {
    public int solution(int[] input) {
        int answer = 1;
        List<Integer> citation = Arrays.stream(input).boxed().collect(Collectors.toList());

        int max = Collections.max(citation);
        for(int h = 0; h <= max; h ++) {
            int count = 0;
            for(int c : citation) {
                if(h <= c) {
                    count ++;
                }
            }
            if(count >= h) {
                answer = h;
            }
        } 

        return answer;
    }
}
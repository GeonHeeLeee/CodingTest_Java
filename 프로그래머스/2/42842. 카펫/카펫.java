import java.util.*;
class Solution {
    int[] answer = {};
    public int[] solution(int brown, int yellow) {
        // w > h
        int size = brown + yellow;
        getCombinations(size, brown, yellow);
        return answer;
    }
    
    public void getCombinations(int size, int brown, int yellow) {
        for(int w = (int) Math.sqrt(size); w <= size; w ++) {
            int h = -1;
            if(size % w == 0) {
                h = size / w;
            }
            
            if(2 * w + 2 * h == brown + 4 && (w - 2) * (h - 2) == yellow) {
                answer = new int[]{w, h};
            }
        }
    }
}
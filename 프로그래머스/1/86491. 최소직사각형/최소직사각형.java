import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;
        for(int[] card : sizes) {
            width = Math.max(width, Math.max(card[1], card[0]));
            height = Math.max(height, Math.min(card[1], card[0]));
        }
        return width * height;
    }
}
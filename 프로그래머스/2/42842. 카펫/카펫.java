class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int tiles = brown + yellow;
        int h;
        int w;
        for(int i = 2; i < (int) Math.sqrt(tiles) + 1; i ++) {
            if(tiles % i == 0) {
                h = i;
                w = tiles/i;
                if(2 * w + 2 * (h-2) == brown) {
                    answer = new int[]{w, h};
                    break;
                }
            }
        }
        return answer;
    }
}
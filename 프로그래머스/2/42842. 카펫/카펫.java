class Solution {
    public int[] solution(int brown, int yellow) {
        int height = 0;
        int width = 0;
        for(int h = 2; h < 2000000; h ++) {
            if((h-2)*(brown - 2* h) == 2 * yellow) {
                width = (brown + 4 - 2 * h)/ 2;
                height = h;
                break;
            }
        }
        return new int[]{width, height};
    }
}
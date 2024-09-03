class Solution {
    public int[] solution(String[] wallpaper) {
        int minX = 100;
        int minY = 100;
        int maxX = -1;
        int maxY = -1;
        for(int i = 0; i < wallpaper.length; i ++) {
            char[] wall = wallpaper[i].toCharArray();
            for(int k = 0; k < wallpaper[0].length(); k ++) {
                if(wall[k] == '#') {
                    minX = Math.min(minX, k);
                    maxX = Math.max(maxX, k + 1);
                    minY = Math.min(minY, i);
                    maxY = Math.max(maxY, i + 1);
                }
            }
        }
        int[] answer = {minY, minX, maxY, maxX};
        return answer;
    }
}
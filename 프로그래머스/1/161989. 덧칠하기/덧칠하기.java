class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int[] wall = new int[n];
        for(int sec : section) {
            wall[sec - 1] = 1;
        }
        for(int sec : section) {
            sec -= 1;
            if(wall[sec] == 0) {
                continue;
            } else {
                if(sec + m < wall.length) {
                    for(int i = sec; i < sec + m; i ++) {
                        wall[i] = 0;
                    }
                    answer += 1;
                } else {
                    for(int i = sec; i < wall.length; i++) {
                        wall[i] = 0;
                    }
                    answer += 1;
                }
            }
        }
        return answer;
    }
}
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int idx = 0;
        int position = 1;
        
        while(position <= n) {
            if(idx < stations.length && position >= stations[idx] - w) {
                position = stations[idx] + w + 1;
                idx ++;
            } else {
                answer ++;
                position += w * 2 + 1;
            }
        }

        return answer;
    }
}
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for(long y = 0; y <= r2; y ++) {
            long maxX = (long) Math.floor(Math.sqrt((double)r2*r2 - y*y));
            long minX = (long) Math.ceil(Math.sqrt((double)r1*r1 - y*y));
            answer += (maxX - minX + 1);
        }
        return (answer - (r2 - r1 + 1)) * 4;
    }
}
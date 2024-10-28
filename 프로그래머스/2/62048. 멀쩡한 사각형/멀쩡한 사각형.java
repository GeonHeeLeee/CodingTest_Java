import java.math.BigInteger;
class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        long gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();
        long similarityH = (long) h / gcd;
        long similarityW = (long) w / gcd;
        
        for(int x = 1; x <= similarityW; x ++) {
            long floor = (long) Math.floor(function(x-1, similarityW, similarityH));
            long ceil = (long) Math.ceil(function(x, similarityW, similarityH));
            answer += (ceil - floor);
        }
        return (long) h * w - (gcd * answer);
    }

    public double function(int x, long w, long h) {
        if(x == 0) {
            return 0;
        }
        return ((double) h / (double) w) * (double) x;
    }
}
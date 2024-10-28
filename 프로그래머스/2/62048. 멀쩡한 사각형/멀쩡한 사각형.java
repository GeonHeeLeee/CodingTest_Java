class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        int gcd = gcd(Math.max(w, h), Math.min(w, h));
        long similarityH = (long) h / gcd;
        long similarityW = (long) w / gcd;
        
        for(int x = 1; x <= similarityW; x ++) {
            long floor = (long) Math.floor(function(x-1, similarityW, similarityH));
            long ceil = (long) Math.ceil(function(x, similarityW, similarityH));
            answer += (ceil - floor);
        }
        return (long) h * w - (gcd * answer);
    }
    public int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public double function(int x, long w, long h) {
        if(x == 0) {
            return 0;
        }
        return ((double) h / (double) w) * (double) x;
    }
}
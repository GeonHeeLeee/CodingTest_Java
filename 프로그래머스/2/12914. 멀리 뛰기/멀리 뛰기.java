class Solution {
    public long solution(int n) {
        long answer = 0;
        int fn2 = 0;
        int fn1 = 1;
        int fn = fn1 + fn2;

        for(int i = 1; i <= n; i ++) {
            fn = (fn1 + fn2) % 1234567;
            fn2 = fn1;
            fn1 = fn;
        }
        
        return fn;
    }
    
}
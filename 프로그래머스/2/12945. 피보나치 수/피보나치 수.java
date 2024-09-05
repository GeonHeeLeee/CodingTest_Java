class Solution {
    public int solution(int n) {
        int fn2 = 0;
        int fn1 = 1;
        int count = 2;
        int fn = 0;
        while(count <= n) {
            fn = (fn1 + fn2) % 1234567;
            fn2 = fn1;
            fn1 = fn;
            count ++;
        }
        if(n == 2) {
            return 1;
        }
        return fn;
    }
}
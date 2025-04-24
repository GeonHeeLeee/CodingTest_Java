import java.util.*;
class Solution {
    int answer = 0;
    static final int MOD = 1000000007;
    public long solution(int n) {
        if(n % 2 != 0) {
            return 0;
        }
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[2] = 3;
        
        for(int i = 4; i <= n; i += 2) {
            dp[i] = dp[i - 2] * 3;
            for(int j = i - 4; j >= 0; j --) {
                dp[i] += dp[j] * 2;
            }
            dp[i] %= MOD;
        }
        return dp[n] % MOD;
    }
    

}
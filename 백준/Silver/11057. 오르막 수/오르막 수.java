import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n == 1) {
            System.out.println(10);
            return;
        }

        long[][] dp = new long[n][10];
        for(int idx = 0; idx < 10; idx ++) {
            dp[0][idx] = 1;
            dp[1][idx] = 10 - idx;
        }
        
        for(int i = 2; i < n; i ++) {
            for(int j = 0; j < 10; j ++) {
                for(int k = j; k < 10; k ++) {
                    dp[i][j] = dp[i][j] + (dp[i-1][k] % 10007);
                }
            }
        }
        long sum = 0;
        for(int idx = 0; idx < 10; idx ++) {
            sum += (dp[n-1][idx]);
        }
        System.out.println(sum % 10007);
    }
}

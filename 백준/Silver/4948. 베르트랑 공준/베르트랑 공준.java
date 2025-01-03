import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[123456 * 2 + 1];
        // n < x <= 2n
        dp[1] = 0;
        dp[2] = 1;
        for(int num = 3; num <= 123456 * 2; num ++) {
            boolean isPrime = true;
            for(int i = 2; i < (int) Math.sqrt(num) + 1; i ++) {
                if(num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            dp[num] = isPrime ? dp[num-1] + 1 : dp[num-1];
        }
        while(true) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                break;
            }
            System.out.println(dp[num * 2] - dp[num]);
        }
    }
}
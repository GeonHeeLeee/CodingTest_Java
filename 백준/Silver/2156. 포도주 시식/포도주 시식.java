
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n];
        int[] wines = new int[n];

        for(int i = 0; i < n; i ++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        if(n == 1) {
            System.out.println(wines[0]);
            return;
        }

        if(n == 2) {
            System.out.println(wines[0] + wines[1]);
            return;
        }

        dp[0] = wines[0];
        dp[1] = wines[0] + wines[1];
        dp[2] = Math.max(wines[1] + wines[2], Math.max(wines[0] + wines[2], dp[1]));

        for(int idx = 3; idx < n; idx ++) {
            dp[idx] = Math.max(dp[idx-1], Math.max(dp[idx-2] + wines[idx], dp[idx-3] + wines[idx] + wines[idx-1]));
        }
        System.out.println(dp[n-1]);
    }


}

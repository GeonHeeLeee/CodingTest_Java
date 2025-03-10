import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] p = new int[n+1];
        int[] dp = new int[n+1];

        for(int index = 1; index <= n; index ++) {
            p[index] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= i; j ++) {
                dp[i] = Math.max(dp[i], dp[i-j] + p[j]);
            } 
        }

        System.out.println(dp[n]);
    }


}

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[n];
        int[] dp = new int[n];
        for(int idx = 0; idx < n; idx ++) {
            input[idx] = Integer.parseInt(st.nextToken());
            dp[idx] = 1;
        }
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < i; j ++) {
                if(input[j] < input[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }

}
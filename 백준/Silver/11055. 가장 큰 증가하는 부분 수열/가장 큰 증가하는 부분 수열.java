import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int[] input = new int[n];
        int[] dp = new int[n];

        for(int i = 0; i < n; i ++) {
            input[i] = Integer.parseInt(st.nextToken());
            dp[i] = input[i];
        }
        
        for(int i = 0; i < n; i ++) {
            for(int j = i; j >= 0; j --) {
                if(input[j] < input[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + input[i]);
                }
            }
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);

    }
}
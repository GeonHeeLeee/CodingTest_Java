import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int answer = Integer.MAX_VALUE;
        int[][] dp = new int[n][3];
        int[][] costs = new int[n][3];
        
        for(int col = 0; col < n; col ++) {
            st = new StringTokenizer(br.readLine());
            for(int row = 0; row < 3; row ++) {
                costs[col][row] = Integer.parseInt(st.nextToken());
                dp[col][row] = col == 0 ? costs[col][row] : Integer.MAX_VALUE;
            }
        }

        for(int col = 1; col < n; col ++) {
            for(int row = 0; row < 3; row ++) {
                for(int idx = 0; idx < 3; idx ++) {
                    if(row != idx) {
                        dp[col][row] = Math.min(dp[col][row], dp[col - 1][idx] + costs[col][row]);
                    }
                }
            }
        }

        for(int row = 0; row < 3; row ++) {
            answer = Math.min(answer, dp[n-1][row]);
        }
        System.out.println(answer);

    }
}

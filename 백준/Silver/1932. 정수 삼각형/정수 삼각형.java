import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        int[][] triangle = new int[n][n];
        int[][] dp = new int[n][n];

        StringTokenizer st;
        for(int col = 0; col < n; col ++) {
            Arrays.fill(triangle[col], -1);
            st = new StringTokenizer(br.readLine());
            for(int row = 0; row <= col; row ++) {
                triangle[col][row] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = triangle[0][0];

        for(int col = 0; col < n - 1; col ++) {
            for(int row = 0; row <= col; row ++) {
                for(int idx = row; idx <= row + 1; idx ++) {
                    if(triangle[col+1][idx] != -1) {
                        dp[col+1][idx] = Math.max(dp[col+1][idx], dp[col][row] + triangle[col+1][idx]);
                    }
                }
            }
        }

        for(int row = 0; row < n; row ++) {
            answer = Math.max(answer, dp[n-1][row]);
        }
        System.out.println(answer);
    }
}

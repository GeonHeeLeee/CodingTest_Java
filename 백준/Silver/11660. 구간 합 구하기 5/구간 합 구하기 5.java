import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] nArr = new int[n][n];
        int[][] dp = new int[n][n];

        for(int row = 0; row < n; row ++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < n; col ++) {
                nArr[row][col] = Integer.parseInt(st.nextToken());
                if(row == 0) {
                    dp[row][col] = nArr[row][col];
                }
            }
        }

        for(int row = 1; row < n; row ++) {
            for(int col = 0; col < n; col ++) {
                dp[row][col] = dp[row-1][col] + nArr[row][col];
            }
        }

        for(int row = 0; row < m; row ++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            int sum = 0;
            for(int col = y1; col <= y2; col ++) {
                if(x1 > 0) {
                    sum = sum + dp[x2][col] - dp[x1-1][col];
                } else {
                    sum += dp[x2][col];
                }
            }
            System.out.println(sum);
        }

    }
}

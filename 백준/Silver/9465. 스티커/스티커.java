import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n;
        int maxSum;
        
        int[][] row0Dir = new int[][]{{0, -2}, {1, -1}, {1, -2}};
        int[][] row1Dir = new int[][]{{0, -2}, {-1, -1}, {-1, -2}};
        int[][] stickers;
        int[][] dp;
        StringTokenizer st;
        
        for(int trial = 0; trial < t; trial ++) {
            n = Integer.parseInt(br.readLine());
            stickers = new int[2][n];
            dp = new int[2][n];
            maxSum = 0;

            for(int row = 0; row < 2; row ++) {
                st = new StringTokenizer(br.readLine());
                for(int col = 0; col < n; col ++) {
                    stickers[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            if(n == 1) {
                System.out.println(Math.max(stickers[0][0], stickers[1][0]));
                continue;
            }
            
            if(n == 2) {
                System.out.println(Math.max(stickers[0][1] + stickers[1][0], stickers[1][1] + stickers[0][0]));
                continue;
            }

            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];

            dp[0][1] = stickers[1][0] + stickers[0][1];
            dp[1][1] = stickers[0][0] + stickers[1][1];

            for(int col = 2; col < n; col ++) {
                for(int row = 0; row < 2; row ++) {
                    if(row == 0) {
                        for(int[] dir : row0Dir) {
                            int dy = row + dir[0];
                            int dx = col + dir[1];
                            dp[row][col] = Math.max(dp[row][col], dp[dy][dx] + stickers[row][col]);
                        }
                    } else {
                        for(int[] dir : row1Dir) {
                            int dy = row + dir[0];
                            int dx = col + dir[1];
                            dp[row][col] = Math.max(dp[row][col], dp[dy][dx] + stickers[row][col]);
                        }
                    }
                    maxSum = Math.max(maxSum, dp[row][col]);
                }
            }
            System.out.println(maxSum);
        }
    } 
}

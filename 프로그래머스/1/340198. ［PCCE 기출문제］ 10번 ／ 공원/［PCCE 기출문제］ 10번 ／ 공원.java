import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int[][] dp = new int[park.length][park[0].length];
        int maxSpace = Integer.MIN_VALUE;
        for(int i = 0; i < park[0].length; i ++) {
            if(park[0][i].equals("-1")) {
                dp[0][i] = 1;
            }
        }
        for(int i = 0; i < park.length; i ++) {
            if(park[i][0].equals("-1")) {
                dp[i][0] = 1;
            }
        }

        for(int i = 1; i < park.length; i ++) {
            for(int j = 1; j < park[0].length; j ++) {
                if(park[i][j].equals("-1")) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    maxSpace = Math.max(dp[i][j], maxSpace);
                }
            }
        }
        Arrays.sort(mats);
        for (int i = mats.length - 1; i >= 0; i--) {
            if (mats[i] <= maxSpace) {
                return mats[i];
            }
        }

        return -1;
    }
}
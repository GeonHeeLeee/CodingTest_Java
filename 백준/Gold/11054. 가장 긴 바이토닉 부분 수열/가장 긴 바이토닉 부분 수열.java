import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];

        for(int i = 0; i < n; i ++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        for(int i = 0; i < n; i ++) {
            for(int j = i; j >= 0; j --) {
                 if(nums[j] < nums[i]) {
                    dp1[i] = Math.max(dp1[j] + 1, dp1[i]);
                 }
            }
        }

        for(int i = n-1; i >= 0; i --) {
            for(int j = i; j < n; j ++) {
                if(nums[j] < nums[i]) {
                    dp2[i] = Math.max(dp2[j] + 1, dp2[i]);
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < n; i ++) {
            answer = Math.max(dp1[i] + dp2[i] + 1, answer);
        }

        System.out.println(answer);
    }
}
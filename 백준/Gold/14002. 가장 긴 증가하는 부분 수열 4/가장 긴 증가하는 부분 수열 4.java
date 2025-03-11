import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1);

        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLength = Math.max(dp[i], maxLength);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        System.out.println(maxLength);
        for (int i = n - 1; i >= 0; i--) {
            if (maxLength == dp[i]) {
                stack.add(nums[i]);
                maxLength--;
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb.toString());

    }
}
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];

        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            if (sum >= s) {
                answer = Math.min(answer, p2 - p1);
                sum -= nums[p1];
                p1++;
            } else if (p2 == n) {
                break;
            } else {
                sum += nums[p2];
                p2++;
            }
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int idx = 0; idx < n; idx++) {
            nums[idx] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int idx = 0; idx < m; idx++) {
            int input = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = n - 1;

            int isInRange = 0;
            while (left <= right) {
                int mid = (left + right) / 2;

                if (input == nums[mid]) {
                    isInRange = 1;
                    break;
                } else if (input < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(isInRange);

        }
    }
}

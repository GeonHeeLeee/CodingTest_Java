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
        int x = Integer.parseInt(br.readLine());

        int first = 0;
        int last = n - 1;
        int answer = 0;
        while (first <= last) {
            if (first == last) {
                break;
            }

            if (nums[first] + nums[last] > x) {
                last--;
            } else if (nums[first] + nums[last] < x) {
                first++;
            } else {
                answer++;
                first++;
            }
        }
        System.out.println(answer);

    }
}

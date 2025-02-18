import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int right = Integer.MIN_VALUE;
        int left = 1;
        int[] jewelies = new int[m];

        for (int i = 0; i < m; i++) {
            jewelies[i] = Integer.parseInt(br.readLine());
            right = Math.max(jewelies[i], right);
        }
        int result = right;

        while (left <= right) {
            int mid = (right + left) / 2;
            int childCount = 0;

            for (int jewely : jewelies) {
                childCount += (jewely / mid) + (jewely % mid == 0 ? 0 : 1);
            }

            if (childCount <= n) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}

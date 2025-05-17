import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] lectures = new int[n];
        int left = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            right += lectures[i];
            left = Math.max(lectures[i], left);
        }

        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            int temp = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                temp += lectures[i];
                if (temp > mid) {
                    count++;
                    temp = lectures[i];
                }
            }

            if (count >= m) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
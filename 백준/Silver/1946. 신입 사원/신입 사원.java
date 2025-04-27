import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int trial = 0; trial < t; trial++) {
            int n = Integer.parseInt(br.readLine());
            int answer = 1;
            int[][] ranks = new int[n][2];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                ranks[i][0] = Integer.parseInt(st.nextToken());
                ranks[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(ranks, (a, b) -> Integer.compare(a[0], b[0]));

            int minInterview = ranks[0][1];

            for (int i = 1; i < n; i++) {
                int curInterview = ranks[i][1];
                if (curInterview < minInterview) {
                    minInterview = curInterview;
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }
}
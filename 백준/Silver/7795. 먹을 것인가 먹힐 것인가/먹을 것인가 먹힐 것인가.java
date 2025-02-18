import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int trial = 0; trial < t; trial++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int count = 0;

            int[] as = new int[n];
            int[] bs = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                as[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                bs[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(bs);

            for (int a : as) {
                for (int b : bs) {
                    if (b >= a) {
                        break;
                    }
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}

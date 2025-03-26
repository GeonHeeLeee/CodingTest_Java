import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long[] modCount = new long[m];
        long answer = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            int mod = (int) (sum % m);
            if (mod == 0) {
                answer++;
            }
            modCount[mod]++;
        }

        for (int i = 0; i < m; i++) {
            if (modCount[i] > 1) {
                answer += (modCount[i] * (modCount[i] - 1)) / 2;
            }
        }

        System.out.println(answer);
    }
}
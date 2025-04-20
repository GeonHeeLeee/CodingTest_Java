import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] sequence = new int[n];

        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        dp1[0] = sequence[0];
        int answer = sequence[0];

        for(int i = 1; i < n; i ++) {
            dp1[i] = Math.max(sequence[i], dp1[i - 1] + sequence[i]);
            answer = Math.max(answer, dp1[i]);
        }

        dp2[n - 1] = sequence[n - 1];
        for(int i = n - 2; i >= 0; i --) {
            dp2[i] = Math.max(sequence[i], dp2[i + 1] + sequence[i]);
        }
        
        for(int i = 1; i < n - 1; i ++) {
            answer = Math.max(answer, dp1[i - 1] + dp2[i + 1]);
        }

        System.out.println(answer);
    }
}
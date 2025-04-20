import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] sequence = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i ++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MIN_VALUE;

        int sum = 0;

        for(int num : sequence) {
            sum = Math.max(sum + num, num);
            answer = Math.max(sum, answer);
        }
        System.out.println(answer);
    }
}
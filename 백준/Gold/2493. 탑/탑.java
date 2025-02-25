import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] towers = new int[n];

        for (int i = 0; i < n; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }
        Stack<int[]> stack = new Stack<>();
        int[] answer = new int[n];
        stack.push(new int[]{towers[n-1], n-1});
        for (int i = n - 1; i >= 0; i--) {


            while (!stack.isEmpty() && towers[i] > stack.peek()[0]) {
                answer[stack.pop()[1]] = i + 1;

            }
            stack.push(new int[] { towers[i], i });
        }
        StringBuilder sb = new StringBuilder();
        for(int a : answer) {
            sb.append(a + " ");
        }
        System.out.println(sb.toString());
    }
}

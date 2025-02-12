import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] meetings = new int[n][2];

        for (int idx = 0; idx < n; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[idx][0] = Integer.parseInt(st.nextToken());
            meetings[idx][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, (a, b) -> {
            int result = a[1] - b[1];
            if (result != 0) {
                return result;
            }
            return a[0] - b[0];
        });
        Stack<Integer> stack = new Stack<>();
        stack.push(meetings[0][1]);
        for (int idx = 1; idx < n; idx++) {
            int start = meetings[idx][0];
            int end = meetings[idx][1];
            int beforeEnd = stack.peek();
            if (beforeEnd <= start) {
                stack.push(end);
            }
        }

        System.out.println(stack.size());
    }
}

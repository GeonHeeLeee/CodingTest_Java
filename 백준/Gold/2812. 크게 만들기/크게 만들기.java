import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];

        String[] input = br.readLine().split("");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        Stack<Integer> stack = new Stack<>();

        for (int num : nums) {
            if (stack.isEmpty()) {
                stack.add(num);
            } else {
                if (k > 0) {
                    while (!stack.isEmpty() && k > 0) {
                        if (stack.peek() < num) {
                            stack.pop();
                            k--;
                        } else {
                            break;
                        }
                    }
                }
                stack.add(num);
            }
        }

        for (int i = 0; i < k; i++) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.reverse().toString());
    }
}
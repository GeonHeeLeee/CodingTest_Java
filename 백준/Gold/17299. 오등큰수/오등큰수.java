import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> ngfMap = new HashMap<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
            if (ngfMap.containsKey(num)) {
                ngfMap.put(num, ngfMap.get(num) + 1);
            } else {
                ngfMap.put(num, 1);
            }
        }

        Stack<int[]> stack = new Stack<>();
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        for (int i = 0; i < n; i++) {
            int curNum = nums[i];
            int curNGF = ngfMap.get(curNum);

            while (!stack.isEmpty()) {
                if (stack.peek()[0] < curNGF) {
                    answer[stack.pop()[2]] = curNum;
                } else {
                    break;
                }
            }
            stack.push(new int[] { curNGF, curNum, i });

        }

        StringBuilder sb = new StringBuilder();
        for (int num : answer) {
            sb.append(num + " ");
        }
        System.out.println(sb.toString());

    }
}
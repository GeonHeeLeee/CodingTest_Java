import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static long t;
    static int[] as;
    static int[] bs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Long.parseLong(br.readLine());
        n = Integer.parseInt(br.readLine());

        as = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            as[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        bs = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            bs[i] = Integer.parseInt(st.nextToken());
        }

        List<Long> aSum = getAllContinuousSums(as);
        List<Long> bSum = getAllContinuousSums(bs);

        Collections.sort(aSum);
        Collections.sort(bSum, Collections.reverseOrder());

        int left = 0;
        int right = 0;
        long answer = 0;

        while (left < aSum.size() && right < bSum.size()) {
            long sum = aSum.get(left) + bSum.get(right);

            if (sum == t) {
                long aValue = aSum.get(left);
                long bValue = bSum.get(right);
                long aCount = 0;
                long bCount = 0;

                while (left < aSum.size() && aSum.get(left) == aValue) {
                    aCount++;
                    left++;
                }

                while (right < bSum.size() && bSum.get(right) == bValue) {
                    bCount++;
                    right++;
                }

                answer += aCount * bCount;
            } else if (sum < t) {
                left++;
            } else {
                right++;
            }

        }

        System.out.println(answer);
    }

    public static List<Long> getAllContinuousSums(int[] arr) {
        List<Long> result = new ArrayList<>();
        int len = arr.length;

        for (int start = 0; start < len; start++) {
            long sum = 0;
            for (int end = start; end < len; end++) {
                sum += arr[end];
                result.add(sum);
            }
        }

        return result;
    }
}
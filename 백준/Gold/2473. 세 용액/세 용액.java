import java.io.*;
import java.util.*;

class Main {
    static int n;
    static long solutionSum = Long.MAX_VALUE;
    static long[] solutions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        solutions = new long[n];
        for (int i = 0; i < n; i++) {
            long input = Long.parseLong(st.nextToken());
            solutions[i] = input;
        }
        Arrays.sort(solutions);
        long a = 0, b = 0, c = 0;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = solutions[i] + solutions[left] + solutions[right];

                if (Math.abs(sum) < solutionSum) {
                    solutionSum = Math.abs(sum);
                    a = solutions[i];
                    b = solutions[left];
                    c = solutions[right];
                }

                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(a + " " + b + " " + c);
    }

}
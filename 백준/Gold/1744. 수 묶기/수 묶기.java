import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        int zeroCount = 0;

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input > 0) {
                positive.add(input);
            } else if (input < 0) {
                negative.add(input);
            } else {
                zeroCount++;
            }

            if (n == 1) {
                System.out.println(input);
                return;
            }
        }

        int answer = 0;

        while (!positive.isEmpty()) {
            if (positive.size() == 1) {
                answer += positive.poll();
                break;
            }
            int current = positive.poll();
            int next = positive.poll();

            if (current == 1 || next == 1) {
                answer += (current + next);
            } else {
                answer += (current * next);
            }
        }

        while (!negative.isEmpty()) {
            if (negative.size() == 1) {
                if (zeroCount > 0) {
                    negative.poll();
                    zeroCount--;
                } else {
                    answer += negative.poll();
                }
                break;
            }

            int current = negative.poll();
            int next = negative.poll();

            answer += (current * next);
        }
        System.out.println(answer);
    }
}
import java.io.*;
import java.util.*;

class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> tasks = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int answer = 0;

        int maxDate = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int due = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            tasks.offer(new int[] { due, score });
            maxDate = Math.max(maxDate, due);
        }

        PriorityQueue<Integer> availableTasks = new PriorityQueue<>(Collections.reverseOrder());

        for (int date = maxDate; date >= 1; date--) {
            while (!tasks.isEmpty() && tasks.peek()[0] >= date) {
                availableTasks.offer(tasks.poll()[1]);
            }

            if (!availableTasks.isEmpty()) {
                answer += availableTasks.poll();
            }
        }

        System.out.println(answer);
    }
}
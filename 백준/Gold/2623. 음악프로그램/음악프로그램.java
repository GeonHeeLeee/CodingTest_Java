import java.io.*;
import java.util.*;

class Main {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[n + 1];
        int[] inDegrees = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int before = 0;
            for (int idx = 0; idx < count; idx++) {
                if (idx == 0) {
                    before = Integer.parseInt(st.nextToken());
                    continue;
                }
                int current = Integer.parseInt(st.nextToken());
                graph[before].add(current);
                inDegrees[current]++;
                before = current;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
                answer.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    queue.offer(next);
                    answer.add(next);
                }
            }
        }

        if (answer.size() == n) {
            for (int person : answer) {
                System.out.println(person);
            }
        } else {
            System.out.println(0);
        }
    }
}
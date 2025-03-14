import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[n + 1];
        int[] inDegrees = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            inDegrees[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int student = 1; student <= n; student++) {
            if (inDegrees[student] == 0) {
                queue.offer(student);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int current = queue.poll();

            sb.append(current + " ");

            for (int next : graph[current]) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
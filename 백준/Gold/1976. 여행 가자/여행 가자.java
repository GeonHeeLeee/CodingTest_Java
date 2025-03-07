import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] plans;
    static boolean[] isReachable;
    static Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        isReachable = new boolean[n + 1];
        plans = new int[m];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph.put(i, new ArrayList<>());
            for (int idx = 1; idx <= n; idx++) {
                int v = Integer.parseInt(st.nextToken());
                if (idx != i && v == 1) {
                    graph.get(i).add(idx);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            plans[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(plans[0]);
        isReachable[plans[0]] = true;

        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            for (int next : graph.get(curNode)) {
                if (!isReachable[next]) {
                    queue.offer(next);
                    isReachable[next] = true;
                }
            }
        }

        String answer = "YES";

        for (int dest : plans) {
            if (!isReachable[dest]) {
                answer = "NO";
            }
        }

        System.out.println(answer);
    }
}
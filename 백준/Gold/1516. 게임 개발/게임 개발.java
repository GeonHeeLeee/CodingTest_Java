import java.io.*;
import java.util.*;

class Main {
    static int n;
    static Map<Integer, Integer> buildingMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] inDegrees = new int[n + 1];
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            buildingMap.put(i, time);

            while (true) {
                int next = Integer.parseInt(st.nextToken());
                if (next == -1) {
                    break;
                }
                graph[next].add(i);
                inDegrees[i]++;

            }

        }

        Queue<Integer> queue = new LinkedList<>();
        int[] answer = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
                answer[i] = buildingMap.get(i);
            }
        }

        while (!queue.isEmpty()) {
            int curBuilding = queue.poll();
            for (int next : graph[curBuilding]) {
                inDegrees[next]--;
                answer[next] = Math.max(answer[next], answer[curBuilding] + buildingMap.get(next));
                if (inDegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        for (int idx = 1; idx <= n; idx++) {
            System.out.println(answer[idx]);
        }

    }
}
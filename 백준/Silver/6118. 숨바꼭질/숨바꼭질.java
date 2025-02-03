import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int minIndex = Integer.MAX_VALUE;
    static int maxCount = 0;
    static int maxDistance = Integer.MIN_VALUE;
    static int[] distance;
    static Map<Integer, List<Integer>> farm = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        distance = new int[n + 1];
        Arrays.fill(distance, -1);

        for (int key = 1; key <= n; key++) {
            farm.put(key, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            farm.get(a).add(b);
            farm.get(b).add(a);
        }

        bfs();

        for (int idx = 2; idx <= n; idx++) {
            if (distance[idx] > maxDistance) {
                maxCount = 1;
                maxDistance = distance[idx];
                minIndex = idx;
            } else if (distance[idx] == maxDistance) {
                maxCount++;
            }
        }
        System.out.print(minIndex + " " + maxDistance + " " + maxCount);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 1, 1 });
        distance[1] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curIndex = current[0];
            int depth = current[1];

            for (int neighbor : farm.get(curIndex)) {
                if (distance[neighbor] == -1 || distance[neighbor] > depth) {
                    distance[neighbor] = depth;
                    queue.add(new int[] { neighbor, depth + 1 });
                }
            }
        }
    }
}

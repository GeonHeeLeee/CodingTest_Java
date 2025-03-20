import java.io.*;
import java.util.*;

class Main {
    static int n, m, start, dest;
    static Map<Integer, List<int[]>> graph = new HashMap<>();
    static int minDist = Integer.MAX_VALUE;
    static int count = 0;
    static String way = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(from).add(new int[] { end, cost });
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(minDist);
        System.out.println(count);
        System.out.println(way);
    }

    public static void bfs() {
        int[] dist = new int[n + 1];
        int[] cityCount = new int[n + 1];
        String[] path = new String[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        path[start] = String.valueOf(start);
        dist[start] = 0;
        cityCount[start] = 1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[] { start, 0 });

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int curNode = current[0];
            int curDist = current[1];

            if (curDist > dist[curNode]) {
                continue;
            }
            
            for (int[] next : graph.get(curNode)) {
                int nextNode = next[0];
                int nextDist = next[1];
                int newDist = nextDist + dist[curNode];

                if (newDist < dist[nextNode]) {
                    pq.offer(new int[] { nextNode, newDist });
                    dist[nextNode] = newDist;
                    cityCount[nextNode] = cityCount[curNode] + 1;
                    path[nextNode] = path[curNode] + " " + nextNode;
                }
            }
        }

        minDist = dist[dest];
        count = cityCount[dest];
        way = path[dest];

    }
}
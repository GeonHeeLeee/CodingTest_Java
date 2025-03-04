import java.io.*;
import java.util.*;

class Main {
    static class Node {
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, List<Node>> nodeMap = new HashMap<>();

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        for (int i = 0; i < v; i++) {
            nodeMap.put(i, new ArrayList<>());
        }

        int first = Integer.parseInt(br.readLine()) - 1;

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int dest = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            nodeMap.get(start).add(new Node(dest, cost));
        }

        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[first] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
        
        pq.offer(new int[] { first, 0 });
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int curNode = current[0];
            int curCost = current[1];

            for (Node next : nodeMap.get(curNode)) {
                int nextNode = next.dest;
                int nextCost = next.cost;
                if (nextCost + curCost < dist[nextNode]) {
                    dist[nextNode] = nextCost + curCost;
                    pq.offer(new int[] { nextNode, nextCost + curCost });
                }
            }
        }

        for (int num : dist) {
            if (num == Integer.MAX_VALUE) {
                System.out.println("INF ");
            } else {
                System.out.println(num);
            }
        }
    }
}
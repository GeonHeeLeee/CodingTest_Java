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

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1;

        Map<Integer, List<Node>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        int[][] toX = new int[n][n];
        int[] toHome = new int[n];

        for (int i = 0; i < n; i++) {
            toX[i][i] = 0;
            Arrays.fill(toX[i], Integer.MAX_VALUE);
        }

        Arrays.fill(toHome, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int dest = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            toX[start][dest] = Math.min(toX[start][dest], cost);
            graph.get(start).add(new Node(dest, cost));
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (toX[i][k] != Integer.MAX_VALUE && toX[k][j] != Integer.MAX_VALUE) {
                        toX[i][j] = Math.min(toX[i][j], toX[i][k] + toX[k][j]);
                    }
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.offer(new int[] { x, 0 });
        toHome[x] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int curNode = current[0];
            int curCost = current[1];

            for (Node next : graph.get(curNode)) {
                int nextNode = next.dest;
                int nextCost = next.cost;

                if (curCost + nextCost < toHome[nextNode]) {
                    toHome[nextNode] = curCost + nextCost;
                    pq.offer(new int[] { nextNode, curCost + nextCost });
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(toX[i][x] + toHome[i], answer);
        }
        System.out.println(answer);
    }
}
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
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        Map<Integer, List<Node>> nodeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodeMap.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int dest = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            nodeMap.get(start).add(new Node(dest, cost));
        }

        int[][] minCosts = new int[n][n];
        for (int[] arr : minCosts) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        for (int idx = 0; idx < n; idx++) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] { idx, 0 });
            minCosts[idx][idx] = 0;
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int curNode = current[0];
                int curCost = current[1];

                for (Node nextNode : nodeMap.get(curNode)) {
                    int dest = nextNode.dest;
                    int cost = nextNode.cost + curCost;
                    if (cost < minCosts[idx][dest]) {
                        minCosts[idx][dest] = cost;
                        queue.offer(new int[] { dest, cost });
                    }
                }
            }
        }

        for (int[] i : minCosts) {
            for (int j : i) {
                if(j == Integer.MAX_VALUE) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}
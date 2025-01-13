import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[][] answer = new int[n][n];
        for(int i = 0; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j ++) {
                if(st.nextToken().equals("1")) {
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }

        for(int start = 0; start < n; start ++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            boolean[] visited = new boolean[n];
            // visited[start] = true;
            while(!queue.isEmpty()) {
                int current = queue.poll();
                if(!graph.containsKey(current)) {
                    continue;
                }
                for(int node : graph.get(current)) {
                    if(!visited[node]) {
                        queue.offer(node);
                        visited[node] = true;
                        answer[start][node] = 1;
                    }
                }
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(answer[row][col] + " ");
            }
            System.out.println();
        }
    }
}

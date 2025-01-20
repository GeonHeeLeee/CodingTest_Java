import java.util.*;
import java.io.*;

public class Main {
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static Map<Integer, Integer> answer = new HashMap<>();
    static int maxValue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i ++) {
            graph.put(i, new ArrayList<>());
        }

        for(int i = 0; i < m; i ++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(b).add(a);
        }
        
        for(int node : graph.keySet()) {
            boolean[] visited = new boolean[n + 1];
            int depth = dfs(node, visited);
            answer.put(node, depth);
            maxValue = Math.max(maxValue, depth);
        }

        for(int key : answer.keySet()) {
            if(answer.get(key) == maxValue) {
                System.out.print(key + " ");
            }
        }
        
    }

    public static int dfs(int node, boolean[] visited) {
        visited[node] = true;
        int depth = 1;

        for(int next : graph.get(node)) {
            if(!visited[next]) {
                depth += dfs(next, visited);
            }
        }

        return depth;
    }
}

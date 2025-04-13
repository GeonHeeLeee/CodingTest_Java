import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] weights;
    static boolean[][] visited;
    static boolean[] possible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        weights = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1][15001];
        possible = new boolean[15001];

        dfs(0, 0);
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int bead = Integer.parseInt(st.nextToken());
            if(bead > 15000) {
                sb.append("N ");
                continue;
            }
            if (possible[bead]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }
        System.out.println(sb.toString());

    }

    public static void dfs(int idx, int weight) {
        if (visited[idx][weight]) {
            return;
        }
        visited[idx][weight] = true;
        possible[weight] = true;

        if (idx == n) {
            return;
        }

        dfs(idx + 1, weight);
        dfs(idx + 1, weight + weights[idx]);
        dfs(idx + 1, Math.abs(weight - weights[idx]));
    }
}
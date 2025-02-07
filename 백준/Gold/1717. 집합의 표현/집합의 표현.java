import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];

        for(int idx = 0; idx <= n; idx ++) {
            parent[idx] = idx;
        }
        for(int i = 0; i < m; i ++) {
            st = new StringTokenizer(br.readLine());
            int operator = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(operator == 0) {
                union(a, b);
            } else {
                if(find(a) != find(b)) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }
    }
    

    public static int find(int node) {
        if(parent[node] != node) {
            node = find(parent[node]);
        }
        return node;
    }

    public static void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        parent[root2] = root1;
    }
}
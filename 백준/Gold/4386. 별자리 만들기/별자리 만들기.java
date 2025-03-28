import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parent = new int[n];
        
        double[][] stars = new double[n][2];

        for(int i = 0; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars[i][0] = x;
            stars[i][1] = y;
            parent[i] = i;
        }

        List<Object[]> edgeList = new ArrayList<>();

        for(int i = 0 ; i < n; i ++) {
            double curx = stars[i][0];
            double cury = stars[i][1];
            for(int j = 0; j < n; j ++) {
                if(i != j) {
                    edgeList.add(new Object[]{i, j, distance(curx, cury, stars[j][0], stars[j][1])});
                }
            }
        }
        Collections.sort(edgeList, (a,b) -> Double.compare((double) a[2], (double) b[2]));
        double answer = 0;
        for(Object[] edge : edgeList) {
            int current = (int) edge[0];
            int next = (int) edge[1];
            double dist = (double) edge[2];

            if(find(current) != find(next)) {
                union(current, next);
                answer += dist;
            }
        }

        System.out.println(answer);
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
    }

    public static int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public static void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 != root2) {
            parent[root2] = root1;
        }
    }
}
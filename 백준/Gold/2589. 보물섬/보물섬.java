import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int m;
    static String[][] map;
    static List<int[]> landList = new ArrayList<>();
    static int maxDistance = Integer.MIN_VALUE;
    static int[][] direction = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new String[n][m];

        for(int row = 0; row < n; row ++) {
            String[] input = br.readLine().split("");
            for(int col = 0; col < m; col ++) {
                map[row][col] = input[col];
                if(map[row][col].equals("L")) {
                    landList.add(new int[]{row, col});
                }
            }
        }
        combinations();
        System.out.println(maxDistance);
    }

    public static void combinations() {
        for(int[] land : landList) {
            maxDistance = Math.max(maxDistance, bfs(land));
        }
    }

    public static int bfs(int[] start) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        int maxDist = 0;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            for(int[] dir : direction) {
                int dy = dir[0] + current[0];
                int dx = dir[1] + current[1];
                int depth = current[2];
                maxDist = Math.max(maxDist, depth);

                if(dy >= 0 && dy < n && dx >= 0 && dx < m && !visited[dy][dx] && map[dy][dx].equals("L")) {
                    queue.offer(new int[]{dy, dx, depth + 1});
                    visited[dy][dx] = true;
                }
            }
        }
        return maxDist;
    }
}

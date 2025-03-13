import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[][] spot;
    static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        spot = new int[m][n];

        for (int row = 0; row < m; row++) {
            char[] input = br.readLine().toCharArray();
            for (int col = 0; col < n; col++) {
                spot[row][col] = input[col] - '0';
            }
        }
        if(n == 1 && m == 1) {
            System.out.println(0);
            return;
        }
        bfs();
        System.out.println(answer);
    }

    public static boolean isInRange(int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }

    public static void bfs() {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        queue.offer(new int[] { 0, 0, 0 });
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int wallCount = current[2];

            for (int[] dir : directions) {
                int dr = dir[0] + row;
                int dc = dir[1] + col;
                if (isInRange(dr, dc) && !visited[dr][dc]) {
                    if (dr == m - 1 && dc == n - 1) {
                        answer = wallCount;
                        return;
                    } else {
                        if (spot[dr][dc] == 1) {
                            queue.offer(new int[] { dr, dc, wallCount + 1 });
                        } else {
                            queue.offer(new int[] { dr, dc, wallCount });
                        }
                        visited[dr][dc] = true;
                    }
                }
            }
        }
    }
}
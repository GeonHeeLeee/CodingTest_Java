import java.io.*;
import java.util.*;

class Main {
    static int n, m, k;
    static int[][] map;
    static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == 1 && m == 1) {
            System.out.println(1);
            return;
        }

        map = new int[n][m];

        for (int r = 0; r < n; r++) {
            char[] input = br.readLine().toCharArray();
            for (int c = 0; c < m; c++) {
                map[r][c] = input[c] - '0';
            }
        }

        boolean[][][] visited = new boolean[n][m][k + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[3], b[3]));
        queue.add(new int[] { 0, 0, k, 1 });
        visited[0][0][k] = true;

        int answer = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int curK = current[2];
            int count = current[3];

            for (int[] dir : directions) {
                int dr = dir[0] + row;
                int dc = dir[1] + col;
                if (dr == n - 1 && dc == m - 1) {
                    answer = Math.min(answer, count + 1);
                    continue;
                }
                if (isInRange(dr, dc)) {
                    if (curK > 0 && !visited[dr][dc][curK - 1] && map[dr][dc] == 1) {
                        visited[dr][dc][curK - 1] = true;
                        queue.offer(new int[] { dr, dc, curK - 1, count + 1 });
                    }

                    if (map[dr][dc] == 0 && !visited[dr][dc][curK]) {
                        visited[dr][dc][curK] = true;
                        queue.offer(new int[] { dr, dc, curK, count + 1 });
                    }
                }

            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

    }

    public static boolean isInRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}
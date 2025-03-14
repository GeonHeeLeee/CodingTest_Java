import java.io.*;
import java.util.*;

class Main {
    static int[][] board;
    static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int r = 0; r < n; r++) {
            char[] input = br.readLine().toCharArray();
            for (int c = 0; c < m; c++) {
                board[r][c] = input[c] - '0';
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[] { 0, 0, 1, 0 });
        boolean[][][] visited = new boolean[n][m][2];
        visited[0][0][0] = true;
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int row = current[0];
            int col = current[1];
            int dist = current[2];
            int wallCount = current[3];

            if (row == n - 1 && col == m - 1) {
                System.out.println(dist);
                return;

            }
            for (int[] dir : directions) {
                int dr = dir[0] + row;
                int dc = dir[1] + col;

                if (isInRange(dr, dc)) {
                    if (board[dr][dc] == 1 && !visited[dr][dc][1] && wallCount == 0) {
                        pq.add(new int[] { dr, dc, dist + 1, wallCount + 1 });
                        visited[dr][dc][1] = true;
                    } else if (board[dr][dc] == 0 && !visited[dr][dc][wallCount]) {
                        pq.add(new int[] { dr, dc, dist + 1, wallCount });
                        visited[dr][dc][wallCount] = true;
                    }

                }
            }
        }

        System.out.println(-1);
    }

    public static boolean isInRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}
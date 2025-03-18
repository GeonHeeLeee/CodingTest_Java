import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[][] board;
    static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    board[r][c] = 4;
                } else {
                    board[r][c] = 0;
                }
            }
        }
        int time = 0;
        while (true) {
            time++;
            bfs();
            boolean isAllMelted = meltCheese();
            if (isAllMelted) {
                System.out.println(time);
                return;
            }
        }

    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0 });
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for (int[] dir : directions) {
                int dr = row + dir[0];
                int dc = col + dir[1];

                if (isInRange(dr, dc) && !visited[dr][dc]) {
                    if (board[dr][dc] > 0) {
                        board[dr][dc]--;
                    } else if (board[dr][dc] == 0) {
                        queue.offer(new int[] { dr, dc });
                        visited[dr][dc] = true;
                    }
                }
            }
        }
    }

    public static boolean meltCheese() {
        boolean isAllMelted = true;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (board[r][c] <= 2 && board[r][c] > 0) {
                    board[r][c] = 0;
                } else if (board[r][c] > 2 && board[r][c] <= 4) {
                    board[r][c] = 4;
                    isAllMelted = false;
                }
            }
        }
        return isAllMelted;
    }

    public static boolean isInRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

}
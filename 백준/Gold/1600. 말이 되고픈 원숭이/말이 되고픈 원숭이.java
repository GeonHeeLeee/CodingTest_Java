import java.io.*;
import java.util.*;

class Main {
    static int[][] horseMoves = new int[][] { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 },
            { -1, -2 },
            { -2, -1 } };
    static int[][] monkeyMoves = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    static int k, w, h;
    static int[][][] dist;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        dist = new int[h][w][k + 1];
        board = new int[h][w];

        for (int[][] arr : dist) {
            for (int[] arr1 : arr) {
                Arrays.fill(arr1, Integer.MAX_VALUE);
            }
        }
        dist[0][0][k] = 0;

        for (int r = 0; r < h; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < w; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            answer = Math.min(dist[h - 1][w - 1][i], answer);
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0, k });

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int curK = current[2];

            for (int[] horseMove : horseMoves) {
                int dr = row + horseMove[0];
                int dc = col + horseMove[1];

                if (isInRange(dr, dc) && board[dr][dc] != 1 && curK > 0
                        && dist[row][col][curK] + 1 < dist[dr][dc][curK - 1]) {
                    dist[dr][dc][curK - 1] = dist[row][col][curK] + 1;
                    queue.offer(new int[] { dr, dc, curK - 1 });
                }
            }

            for (int[] monkeyMove : monkeyMoves) {
                int dr = row + monkeyMove[0];
                int dc = col + monkeyMove[1];

                if (isInRange(dr, dc) && board[dr][dc] != 1 && dist[row][col][curK] + 1 < dist[dr][dc][curK]) {
                    dist[dr][dc][curK] = dist[row][col][curK] + 1;
                    queue.offer(new int[] { dr, dc, curK });
                }
            }
        }
    }

    public static boolean isInRange(int row, int col) {
        return row >= 0 && col >= 0 && row < h && col < w;
    }
}
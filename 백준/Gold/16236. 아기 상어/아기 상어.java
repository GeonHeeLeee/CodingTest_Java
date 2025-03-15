import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] ocean;
    static int[] start;
    static int fishCount = 0;
    static int size = 2;
    static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ocean = new int[n][n];

        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                ocean[r][c] = Integer.parseInt(st.nextToken());
                if (ocean[r][c] == 9) {
                    start = new int[] { r, c };
                    ocean[r][c] = 0;
                }
            }
        }


        bfs();
        System.out.println(time);

    }

    public static void bfs() {
        int row = start[0];
        int col = start[1];
        while (true) {
            int[][] dist = new int[n][n];
            for (int[] d : dist) {
                Arrays.fill(d, -1);
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[2] - b[2] != 0) {
                    return a[2] - b[2];
                }
                if (a[0] - b[0] != 0) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            });

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] { row, col });
            dist[row][col] = 0;
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int curRow = current[0];
                int curCol = current[1];

                for (int[] dir : directions) {
                    int dr = dir[0] + curRow;
                    int dc = dir[1] + curCol;

                    if (isInRange(dr, dc) && dist[dr][dc] == -1 && ocean[dr][dc] <= size) {
                        dist[dr][dc] = dist[curRow][curCol] + 1;
                        queue.offer(new int[] { dr, dc });
                        if (ocean[dr][dc] > 0 && ocean[dr][dc] < size) {
                            pq.offer(new int[] { dr, dc, dist[dr][dc] });
                        }
                    }
                }
            }

            if (pq.isEmpty()) {
                return;
            }

            int[] fish = pq.poll();
            row = fish[0];
            col = fish[1];
            time += fish[2];
            ocean[row][col] = 0;
            fishCount++;

            if (fishCount >= size) {
                fishCount = 0;
                size++;
            }

        }

    }

    public static boolean isInRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}
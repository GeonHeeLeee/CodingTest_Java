import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] map;
    static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int landCount = 2;
        boolean[][] visited = new boolean[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (map[r][c] == 1 && !visited[r][c]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] { r, c });
                    visited[r][c] = true;

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int row = current[0];
                        int col = current[1];

                        for (int[] dir : directions) {
                            int dr = row + dir[0];
                            int dc = col + dir[1];

                            if (isInRange(dr, dc)) {
                                if (map[dr][dc] == 0) {
                                    map[row][col] = landCount;
                                }
                                if (map[dr][dc] == 1 && !visited[dr][dc]) {
                                    queue.offer(new int[] { dr, dc });
                                    visited[dr][dc] = true;
                                }
                            }
                        }
                    }
                    landCount++;
                }
            }
        }

        int minBridge = Integer.MAX_VALUE;

        for (int land = 2; land < landCount; land++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (map[r][c] == land) {
                        Queue<int[]> queue = new LinkedList<>();
                        queue.offer(new int[] { r, c, 0 });
                        visited = new boolean[n][n];
                        visited[r][c] = true;

                        while (!queue.isEmpty()) {
                            int[] current = queue.poll();
                            int row = current[0];
                            int col = current[1];
                            int dist = current[2];

                            for (int[] dir : directions) {
                                int dr = row + dir[0];
                                int dc = col + dir[1];

                                if (isInRange(dr, dc) && !visited[dr][dc] && map[dr][dc] != land) {
                                    if (map[dr][dc] > 1) {
                                        minBridge = Math.min(minBridge, dist);
                                    } else if (dist < minBridge && map[dr][dc] == 0) {
                                        queue.offer(new int[] { dr, dc, dist + 1 });
                                        visited[dr][dc] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(minBridge);
    }

    public static boolean isInRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}
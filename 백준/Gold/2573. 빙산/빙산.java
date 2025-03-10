import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[][] ice;
    static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ice = new int[n][m];

        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < m; col++) {
                ice[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (true) {
            int[][] temp = new int[n][m];
            int maxIce = -1;
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    int count = 0;
                    if (ice[row][col] != 0) {
                        for (int[] dir : directions) {
                            int dr = row + dir[0];
                            int dc = col + dir[1];

                            if (isInRange(dr, dc) && ice[dr][dc] == 0) {
                                count++;
                            }
                        }
                        temp[row][col] = ice[row][col] < count ? 0 : ice[row][col] - count;
                        maxIce = Math.max(maxIce, temp[row][col]);
                    }
                }

            }

            if (isSeperated()) {
                System.out.println(time);
                return;
            } else if (maxIce == 0) {
                System.out.println(0);
                return;
            }

            copyArr(temp, ice);
            time++;
        }

    }

    public static void copyArr(int[][] temp, int[][] ice) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                ice[row][col] = temp[row][col];
            }
        }
    }

    public static boolean isSeperated() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (ice[row][col] != 0 && !visited[row][col]) {
                    queue.offer(new int[] { row, col });
                    visited[row][col] = true;
                    count++;
                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int curRow = current[0];
                        int curCol = current[1];

                        for (int[] dir : directions) {
                            int dr = curRow + dir[0];
                            int dc = curCol + dir[1];
                            if (isInRange(dr, dc) && ice[dr][dc] != 0 && !visited[dr][dc]) {
                                queue.offer(new int[] { dr, dc });
                                visited[dr][dc] = true;
                            }
                        }
                    }
                }
                if (count > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isInRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}
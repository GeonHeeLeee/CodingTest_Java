import java.io.*;
import java.util.*;

class Main {
    static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int problemIndex = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            int[][] map = new int[n][n];

            for (int r = 0; r < n; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < n; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            int minRupee = bfs(n, map);
            System.out.println(getAnswerFormat(problemIndex ++, minRupee));
        }
    }

    public static int bfs(int n, int[][] map) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0, map[0][0] });
        int[][] minRupee = new int[n][n];
        for(int[] arr : minRupee) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        minRupee[0][0] = map[0][0];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curRow = current[0];
            int curCol = current[1];
            int curRupee = minRupee[curRow][curCol];
            for (int[] dir : directions) {
                int row = dir[0] + curRow;
                int col = dir[1] + curCol;

                if (isInRange(n, row, col) && curRupee + map[row][col] < minRupee[row][col]) {
                    queue.offer(new int[] { row, col });
                    minRupee[row][col] = curRupee + map[row][col];
                }
            }
        }
        return minRupee[n - 1][n - 1];
    }

    public static boolean isInRange(int n, int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    public static String getAnswerFormat(int index, int answer) {
        return "Problem " + index + ": " + answer;
    }
}
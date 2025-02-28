import java.io.*;
import java.util.*;

class Main {
    static int[][] paper;
    static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    static int n;
    static int m;
    static int answer = Integer.MIN_VALUE;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n][m];
        visited = new boolean[n][m];

        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < m; col++) {
                paper[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                visited[row][col] = true;
                dfs(1, paper[row][col], row, col);
                visited[row][col] = false;
                checkTShape(row, col);
            }
        }

        System.out.println(answer);

    }

    public static void checkTShape(int row, int col) {

        // ㅜ
        if (isInRange(row, col - 1) && isInRange(row, col + 1) && isInRange(row + 1, col)) {
            answer = Math.max(answer,
                    paper[row][col] + paper[row][col - 1] + paper[row][col + 1] + paper[row + 1][col]);
        }

        // ㅗ
        if (isInRange(row, col - 1) && isInRange(row, col + 1) && isInRange(row - 1, col)) {
            answer = Math.max(answer,
                    paper[row][col] + paper[row][col - 1] + paper[row][col + 1] + paper[row - 1][col]);
        }

        // ㅓ
        if (isInRange(row, col - 1) && isInRange(row - 1, col) && isInRange(row + 1, col)) {
            answer = Math.max(answer,
                    paper[row][col] + paper[row][col - 1] + paper[row - 1][col] + paper[row + 1][col]);
        }

        // ㅏ
        if (isInRange(row, col + 1) && isInRange(row - 1, col) && isInRange(row + 1, col)) {
            answer = Math.max(answer,
                    paper[row][col] + paper[row][col + 1] + paper[row - 1][col] + paper[row + 1][col]);
        }
    }

    public static void dfs(int count, int sum, int row, int col) {
        if (count == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int[] dir : directions) {
            int dr = dir[0] + row;
            int dc = dir[1] + col;

            if (isInRange(dr, dc) && !visited[dr][dc]) {
                visited[dr][dc] = true;
                dfs(count + 1, sum + paper[dr][dc], dr, dc);
                visited[dr][dc] = false;
            }
        }
    }

    public static boolean isInRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}
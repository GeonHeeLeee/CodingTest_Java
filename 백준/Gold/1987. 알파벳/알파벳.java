import java.io.*;
import java.util.*;

class Main {
    static int r;
    static int c;
    static char[][] board;
    static boolean[] visited = new boolean[26];
    static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        // 17
        // 42
        for (int row = 0; row < r; row++) {
            char[] input = br.readLine().toCharArray();
            for (int col = 0; col < c; col++) {
                board[row][col] = input[col];
            }
        }
        visited[(board[0][0] - '0') - 17] = true;
        dfs(0, 0, 1);
        System.out.println(answer);

    }

    public static void dfs(int row, int col, int count) {
        answer = Math.max(count, answer);
        for (int[] dir : directions) {
            int dr = row + dir[0];
            int dc = col + dir[1];

            if (isInRange(dr, dc) && !visited[(board[dr][dc] - '0') - 17]) {
                int alpha = (board[dr][dc] - '0') - 17;
                visited[alpha] = true;
                dfs(dr, dc, count + 1);
                visited[alpha] = false;
            }
        }
    }

    public static boolean isInRange(int row, int col) {
        return row >= 0 && row < r && col >= 0 && col < c;
    }
}
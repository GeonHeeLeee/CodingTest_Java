import java.io.*;
import java.util.*;

class Main {
    static int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
    static int n;
    static int m;
    static int[] dice = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < m; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());

        int curRow = x;
        int curCol = y;

        for (int i = 0; i < k; i++) {
            int command = Integer.parseInt(st.nextToken()) - 1;
            // 오른쪽 0, 왼쪽 1, 위 2, 아래 3

            int dr = curRow + directions[command][0];
            int dc = curCol + directions[command][1];

            if (!isInRange(dr, dc)) {
                continue;
            }

            moveDice(command);
            if (board[dr][dc] == 0) {
                board[dr][dc] = dice[5];
            } else {
                dice[5] = board[dr][dc];
                board[dr][dc] = 0;
            }

            System.out.println(dice[2]);

            curRow = dr;
            curCol = dc;
        }

    }

    public static boolean isInRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    public static void moveDice(int command) {
        int tmp = dice[5];
        switch (command) {
            case 0:
                dice[5] = dice[3];
                dice[3] = dice[2];
                dice[2] = dice[1];
                dice[1] = tmp;
                break;
            case 1:
                dice[5] = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[3];
                dice[3] = tmp;
                break;
            case 2:
                dice[5] = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[4];
                dice[4] = tmp;
                break;

            case 3:
                dice[5] = dice[4];
                dice[4] = dice[2];
                dice[2] = dice[0];
                dice[0] = tmp;
                break;
        }
    }
}
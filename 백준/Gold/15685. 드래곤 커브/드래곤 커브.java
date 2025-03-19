import java.io.*;
import java.util.*;

class Main {
    static int n;
    static boolean[][] board;
    static int[][] dragons;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new boolean[101][101];
        dragons = new int[n][];

        // 방향: 0(→), 1(↑), 2(←), 3(↓)
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            int length = (int) Math.pow(2, g);
            dragons[i] = new int[length];
            dragons[i][0] = d;

            for (int j = 1; j <= g; j++) {
                int beforeLen = (int) Math.pow(2, j - 1);
                for (int k = 0; k < beforeLen; k++) {
                    dragons[i][beforeLen + k] = (dragons[i][beforeLen - k - 1] + 1) % 4;
                }
            }

            board[x][y] = true;
            int curX = x, curY = y;
            for (int dir : dragons[i]) {
                curX += dx[dir];
                curY += dy[dir];
                board[curX][curY] = true;
            }
        }

        int answer = 0;
        for (int row = 0; row < 100; row++) {
            for (int col = 0; col < 100; col++) {
                if (board[row][col] && board[row + 1][col] && board[row][col + 1] && board[row + 1][col + 1]) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}

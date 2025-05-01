import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int blues = 0;
    static int whites = 0;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        splitBoard(n, 0, 0);
        System.out.println(whites);
        System.out.println(blues);
    }

    public static void splitBoard(int n, int row, int col) {
        int current = board[row][col];
        boolean isPerfect = true;
        for (int r = row; r < row + n; r++) {
            for (int c = col; c < col + n; c++) {
                if (board[r][c] != current) {
                    isPerfect = false;
                    break;
                }
            }
        }

        if (isPerfect) {
            if (current == 1) {
                blues++;
            } else {
                whites++;
            }
        } else {
            splitBoard(n / 2, row, col);
            splitBoard(n / 2, row + n / 2, col);
            splitBoard(n / 2, row, col + n / 2);
            splitBoard(n / 2, row + n / 2, col + n / 2);
        }
    } 
}
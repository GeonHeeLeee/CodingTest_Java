import java.io.*;

class Main {
    static boolean[][] chess;
    static int n;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        chess = new boolean[n][n];

        play(0);
        System.out.println(answer);
    }

    public static void play(int row) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (canAttack(row, col)) {
                chess[row][col] = true;
                play(row + 1);
                chess[row][col] = false;
            }
        }
    }

    public static boolean canAttack(int row, int col) {
        for (int r = 0; r < n; r++) {
            if (chess[r][col]) {
                return false;
            }
        }

        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            if (chess[row - i][col - i]) {
                return false;
            }
        }
        for (int i = 1; row - i >= 0 && col + i < n; i++) {
            if (chess[row - i][col + i]) {
                return false;
            }
        }

        return true;
    }
}
import java.io.*;
import java.util.*;

class Main {

    static int[][] sudoku = new int[9][9];
    static List<int[]> blanks = new ArrayList<>();
    static boolean isSolved = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int r = 0; r < 9; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 9; c++) {
                sudoku[r][c] = Integer.parseInt(st.nextToken());
                if (sudoku[r][c] == 0) {
                    blanks.add(new int[] { r, c });
                }
            }
        }

        solve(0);
        for (int[] row : sudoku) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void solve(int idx) {
        if (idx == blanks.size()) {
            isSolved = true;
            return;
        }

        int row = blanks.get(idx)[0];
        int col = blanks.get(idx)[1];

        for (int num = 1; num <= 9; num++) {
            if (isValid(row, col, num)) {
                sudoku[row][col] = num;
                solve(idx + 1);
                if (isSolved) {
                    return;
                }
                sudoku[row][col] = 0;
            }
        }
    }

    public static boolean isValid(int row, int col, int num) {
        for (int c = 0; c < 9; c++) {
            if (sudoku[row][c] == num) {
                return false;
            }
        }

        for (int r = 0; r < 9; r++) {
            if (sudoku[r][col] == num) {
                return false;
            }
        }

        row = (row / 3) * 3;
        col = (col / 3) * 3;

        for (int r = row; r < row + 3; r++) {
            for (int c = col; c < col + 3; c++) {
                if (sudoku[r][c] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
import java.io.*;
import java.util.*;

class Main {
    static int[][] sudoku = new int[9][9];
    static List<int[]> notFilled = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int r = 0; r < 9; r++) {
            char[] input = br.readLine().toCharArray();
            for (int c = 0; c < 9; c++) {
                sudoku[r][c] = input[c] - '0';
                if (sudoku[r][c] == 0) {
                    notFilled.add(new int[] { r, c });
                }
            }
        }
        dfs(0);

    }

    public static void dfs(int index) {
        if (index == notFilled.size()) {
            for (int[] a : sudoku) {
                for (int b : a) {
                    System.out.print(b);
                }
                System.out.println();
            }
            System.exit(0);
        }

        int curRow = notFilled.get(index)[0];
        int curCol = notFilled.get(index)[1];

        List<Integer> possibles = possibleNums(curRow, curCol);
        if (possibles.isEmpty()) {
            return;
        }
        for (int num : possibles) {
            sudoku[curRow][curCol] = num;
            dfs(index + 1);
            sudoku[curRow][curCol] = 0;
        }

    }

    public static List<Integer> possibleNums(int row, int col) {
        boolean[] possibles = new boolean[10];

        for (int r = 0; r < 9; r++) {
            possibles[sudoku[r][col]] = true;
        }

        for (int c = 0; c < 9; c++) {
            possibles[sudoku[row][c]] = true;
        }

        for (int r = (row / 3) * 3; r < (row / 3) * 3 + 3; r++) {
            for (int c = (col / 3) * 3; c < (col / 3) * 3 + 3; c++) {
                possibles[sudoku[r][c]] = true;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (!possibles[i]) {
                result.add(i);
            }
        }

        return result;
    }
}
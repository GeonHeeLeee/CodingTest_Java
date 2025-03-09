import java.io.*;
import java.util.*;

class Main {
    static int r, c;
    static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] board = new int[r][c];
        List<int[]> airPurifier = new ArrayList<>();
        for (int row = 0; row < r; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < c; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
                if (board[row][col] == -1) {
                    airPurifier.add(new int[] { row, col });
                }
            }
        }

        for (int time = 0; time < t; time++) {
            int[][] temp = new int[r][c];
            for (int row = 0; row < r; row++) {
                for (int col = 0; col < c; col++) {
                    spread(row, col, board, temp);
                }
            }
            runFirstAirPurifier(airPurifier.get(0)[0], airPurifier.get(0)[1], temp);
            runSecondAirPurifier(airPurifier.get(1)[0], airPurifier.get(1)[1], temp);
            for (int row = 0; row < r; row++) {
                for (int col = 0; col < c; col++) {
                    board[row][col] = temp[row][col];
                }
            }
        }

        int answer = 0;
        for (int[] row : board) {
            for (int num : row) {
                if (num != -1) {
                    answer += num;
                }
            }
        }

        System.out.println(answer);
    }

    public static boolean isInRange(int row, int col) {
        return row >= 0 && row < r && col >= 0 && col < c;
    }

    public static void spread(int row, int col, int[][] board, int[][] temp) {
        if (board[row][col] > 0) {
            int count = 0;
            int spreadAmount = board[row][col] / 5;
            for (int[] dir : directions) {
                int dr = dir[0] + row;
                int dc = dir[1] + col;

                if (isInRange(dr, dc) && board[dr][dc] != -1) {
                    count++;
                    temp[dr][dc] += spreadAmount;
                }
            }
            temp[row][col] += (board[row][col] - spreadAmount * count);
        } else {
            temp[row][col] += board[row][col];
        }
    }

    public static void runFirstAirPurifier(int curRow, int curCol, int[][] temp) {

        for (int row = curRow - 1; row > 0; row--)
            temp[row][0] = temp[row - 1][0];
        for (int col = 0; col < c - 1; col++)
            temp[0][col] = temp[0][col + 1];
        for (int row = 0; row < curRow; row++)
            temp[row][c - 1] = temp[row + 1][c - 1];
        for (int col = c - 1; col > 1; col--)
            temp[curRow][col] = temp[curRow][col - 1];

        temp[curRow][1] = 0;
    }

    public static void runSecondAirPurifier(int curRow, int curCol, int[][] temp) {
        for (int row = curRow + 1; row < r - 1; row++)
            temp[row][0] = temp[row + 1][0];
        for (int col = 0; col < c - 1; col++)
            temp[r - 1][col] = temp[r - 1][col + 1];
        for (int row = r - 1; row > curRow; row--)
            temp[row][c - 1] = temp[row - 1][c - 1];
        for (int col = c - 1; col > 1; col--)
            temp[curRow][col] = temp[curRow][col - 1];

        temp[curRow][1] = 0;
    }
}
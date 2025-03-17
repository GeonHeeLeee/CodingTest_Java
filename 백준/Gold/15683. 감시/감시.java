import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[][] board;
    static List<int[]> cctvList = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
                if (board[r][c] >= 1 && board[r][c] <= 5) {
                    cctvList.add(new int[] { board[r][c], r, c });
                }
            }
        }
        dfs(0);
        System.out.println(answer);

    }

    public static void dfs(int index) {
        if (index == cctvList.size()) {
            answer = Math.min(answer, countBlindSpot());

            return;
        }

        int[] current = cctvList.get(index);

        int cctvNum = current[0];
        int row = current[1];
        int col = current[2];

        switch (cctvNum) {
            case 1:
                for (int dir = 1; dir <= 4; dir++) {
                    boolean[][] visited = firstCCTV(row, col, dir);
                    dfs(index + 1);
                    rollBack(visited);
                }
                break;
            case 2:
                for (int dir = 1; dir <= 2; dir++) {
                    boolean[][] visited = secondCCTV(row, col, dir);
                    dfs(index + 1);
                    rollBack(visited);

                }
                break;
            case 3:
                for (int dir = 1; dir <= 4; dir++) {
                    boolean[][] visited = thirdCCTV(row, col, dir);
                    dfs(index + 1);
                    rollBack(visited);

                }
                break;
            case 4:
                for (int dir = 1; dir <= 4; dir++) {
                    boolean[][] visited = fourthCCTV(row, col, dir);
                    dfs(index + 1);
                    rollBack(visited);

                }
                break;
            case 5:
                boolean[][] visited = fifthCCTV(row, col);
                dfs(index + 1);
                rollBack(visited);

                break;
        }

    }

    public static void rollBack(boolean[][] visited) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (visited[r][c]) {
                    board[r][c] = 0;
                }
            }
        }
    }

    public static int countBlindSpot() {
        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (board[row][col] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean[][] firstCCTV(int row, int col, int direction) {
        boolean[][] visited = new boolean[n][m];
        switch (direction) {
            case 1:
                watchRight(row, col, visited);
                break;
            case 2:
                watchUnder(row, col, visited);
                break;
            case 3:
                watchLeft(row, col, visited);
                break;
            case 4:
                watchAbove(row, col, visited);
                break;
        }
        return visited;
    }

    public static boolean[][] secondCCTV(int row, int col, int direction) {
        boolean[][] visited = new boolean[n][m];

        switch (direction) {
            case 1:
                watchRight(row, col, visited);
                watchLeft(row, col, visited);
                break;
            case 2:
                watchUnder(row, col, visited);
                watchAbove(row, col, visited);
                break;
        }
        return visited;

    }

    public static boolean[][] thirdCCTV(int row, int col, int direction) {
        boolean[][] visited = new boolean[n][m];

        switch (direction) {
            case 1:
                watchAbove(row, col, visited);
                watchRight(row, col, visited);
                break;
            case 2:
                watchRight(row, col, visited);
                watchUnder(row, col, visited);
                break;
            case 3:
                watchLeft(row, col, visited);
                watchUnder(row, col, visited);
                break;
            case 4:
                watchLeft(row, col, visited);
                watchAbove(row, col, visited);
                break;
        }
        return visited;

    }

    public static boolean[][] fourthCCTV(int row, int col, int direction) {
        boolean[][] visited = new boolean[n][m];

        switch (direction) {
            case 1:
                watchAbove(row, col, visited);
                watchLeft(row, col, visited);
                watchRight(row, col, visited);
                break;
            case 2:
                watchAbove(row, col, visited);
                watchRight(row, col, visited);
                watchUnder(row, col, visited);
                break;
            case 3:
                watchRight(row, col, visited);
                watchUnder(row, col, visited);
                watchLeft(row, col, visited);
                break;
            case 4:
                watchLeft(row, col, visited);
                watchUnder(row, col, visited);
                watchAbove(row, col, visited);
                break;
        }
        return visited;

    }

    public static boolean[][] fifthCCTV(int row, int col) {
        boolean[][] visited = new boolean[n][m];
        watchLeft(row, col, visited);
        watchAbove(row, col, visited);
        watchRight(row, col, visited);
        watchUnder(row, col, visited);
        return visited;

    }

    public static void watchLeft(int row, int col, boolean[][] visited) {
        for (int c = col - 1; c >= 0; c--) {
            if (board[row][c] == 6) {
                return;
            } else if (board[row][c] == 0) {
                board[row][c] = -1;
                visited[row][c] = true;
            }
        }
    }

    public static void watchAbove(int row, int col, boolean[][] visited) {
        for (int r = row - 1; r >= 0; r--) {
            if (board[r][col] == 6) {
                return;
            } else if (board[r][col] == 0) {
                board[r][col] = -1;
                visited[r][col] = true;

            }
        }
    }

    public static void watchUnder(int row, int col, boolean[][] visited) {
        for (int r = row + 1; r < n; r++) {
            if (board[r][col] == 6) {
                return;
            } else if (board[r][col] == 0) {
                board[r][col] = -1;
                visited[r][col] = true;
            }
        }
    }

    public static void watchRight(int row, int col, boolean[][] visited) {
        for (int c = col + 1; c < m; c++) {
            if (board[row][c] == 6) {
                return;
            } else if (board[row][c] == 0) {
                board[row][c] = -1;
                visited[row][c] = true;
            }
        }
    }
}
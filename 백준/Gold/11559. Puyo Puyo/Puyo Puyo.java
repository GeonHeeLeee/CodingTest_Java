import java.io.*;
import java.util.*;

public class Main {
    static char[][] field;
    static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        field = new char[12][6];

        for (int i = 0; i < 12; i++) {
            String input = br.readLine();
            field[i] = input.toCharArray();
        }

        int trial = 0;
        boolean isRemoved = false;

        while (true) {
            List<int[]> removedBlocks = new ArrayList<>();
            for (int row = 0; row < 12; row++) {
                for (int col = 0; col < 6; col++) {
                    if (field[row][col] != '.') {
                        Queue<int[]> queue = new LinkedList<>();
                        queue.offer(new int[] { row, col, (int) field[row][col] });
                        Stack<int[]> stack = new Stack<>();
                        boolean[][] visited = new boolean[12][6];
                        visited[row][col] = true;
                        stack.push(new int[] { row, col });

                        while (!queue.isEmpty()) {
                            int[] current = queue.poll();
                            int curRow = current[0];
                            int curCol = current[1];
                            int curLetter = current[2];

                            for (int[] direction : directions) {
                                int dr = curRow + direction[0];
                                int dc = curCol + direction[1];

                                if (dr >= 0 && dc >= 0 && dr < 12 && dc < 6 && !visited[dr][dc]
                                        && curLetter == field[dr][dc]) {
                                    queue.offer(new int[] { dr, dc, curLetter });
                                    stack.push(new int[] { dr, dc });
                                    visited[dr][dc] = true;
                                }
                            }
                        }
                        if (stack.size() >= 4) {
                            for (int[] block : stack) {
                                removedBlocks.add(block);
                                field[block[0]][block[1]] = '.';
                            }
                            isRemoved = true;
                        }
                    }
                }
            }
            if (isRemoved) {
                isRemoved = false;
                trial++;
                rebuild(removedBlocks);
            } else {
                break;
            }

        }
        System.out.println(trial);

    }

    public static void rebuild(List<int[]> blocks) {
        for (int[] block : blocks) {
            int curRow = block[0];
            int curCol = block[1];

            for (int row = curRow; row >= 0; row--) {
                if (row - 1 >= 0) {
                    field[row][curCol] = field[row - 1][curCol];
                }
            }
            field[0][curCol] = '.';
        }
    }
}

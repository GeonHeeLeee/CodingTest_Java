import java.io.*;
import java.util.*;

class Main {
    static int r, c;
    static char[][] forest;
    static int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    static List<int[]> waterList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        forest = new char[r][c];

        int[] hedgehog = null;
        int[] beaver = null;

        for (int row = 0; row < r; row++) {
            String input = br.readLine();
            for (int col = 0; col < c; col++) {
                forest[row][col] = input.charAt(col);

                if (forest[row][col] == 'S') {
                    hedgehog = new int[] { row, col };
                } else if (forest[row][col] == 'D') {
                    beaver = new int[] { row, col };
                } else if (forest[row][col] == '*') {
                    waterList.add(new int[] { row, col });
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        queue.add(new int[] { hedgehog[0], hedgehog[1], 0 });
        boolean[][] visited = new boolean[r][c];
        visited[hedgehog[0]][hedgehog[1]] = true;

        for (int t = 0; t <= r * c; t++) {
            spreadWater();
            while (!queue.isEmpty()) {
                if (queue.peek()[2] == t) {
                    int[] curHedgehog = queue.poll();
                    int row = curHedgehog[0];
                    int col = curHedgehog[1];
                    int time = curHedgehog[2];

                    for (int[] dir : directions) {
                        int dr = dir[0] + row;
                        int dc = dir[1] + col;

                        if (isInRange(dr, dc) && !visited[dr][dc] && (forest[dr][dc] == '.' || forest[dr][dc] == 'D')) {
                            if (forest[dr][dc] == 'D') {
                                answer = Math.min(answer, time + 1);
                            } else {
                                visited[dr][dc] = true;
                                queue.offer(new int[] { dr, dc, time + 1 });
                            }
                        }
                    }
                } else {
                    break;
                }
            }
        }
        if (answer == Integer.MAX_VALUE) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(answer);
        }
    }

    public static boolean isInRange(int row, int col) {
        return row >= 0 && row < r && col >= 0 && col < c;
    }

    public static void spreadWater() {
        List<int[]> newWaterList = new ArrayList<>();

        for (int[] water : waterList) {
            int row = water[0];
            int col = water[1];

            for (int[] dir : directions) {
                int dr = row + dir[0];
                int dc = col + dir[1];

                if (isInRange(dr, dc) && forest[dr][dc] == '.') {
                    forest[dr][dc] = '*';
                    newWaterList.add(new int[] { dr, dc });
                }
            }
        }

        waterList = newWaterList;
    }
}
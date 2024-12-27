import java.util.*;

class Road {
    int y, x, cost, dir;

    public Road(int y, int x, int cost, int dir) {
        this.y = y;
        this.x = x;
        this.cost = cost;
        this.dir = dir;
    }
}

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int[][][] cost = new int[n][n][4];
        for (int[][] row : cost) for (int[] col : row) Arrays.fill(col, Integer.MAX_VALUE);

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<Road> queue = new LinkedList<>();
        
        for (int d = 0; d < 4; d++) cost[0][0][d] = 0;
        queue.offer(new Road(0, 0, 0, -1));

        while (!queue.isEmpty()) {
            Road current = queue.poll();

            for (int d = 0; d < 4; d++) {
                int dy = current.y + directions[d][0];
                int dx = current.x + directions[d][1];

                if (dy >= 0 && dy < n && dx >= 0 && dx < n && board[dy][dx] == 0) {
                    int newCost = current.cost;

                    if (current.dir == -1 || current.dir == d) {
                        newCost += 100;
                    } else {
                        newCost += 600;
                    }


                    if (newCost < cost[dy][dx][d]) {
                        cost[dy][dx][d] = newCost;
                        queue.offer(new Road(dy, dx, newCost, d));
                    }
                }
            }
        }

        return Arrays.stream(cost[n - 1][n - 1]).min().getAsInt();
    }
}

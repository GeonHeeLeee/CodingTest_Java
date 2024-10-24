import java.util.*;
class Solution {
    public int solution(String[] board) {
        int answer = -1;
        boolean[][] visited = new boolean[board.length][board[0].length()];
        int[][] dir = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        char[][] cBoard = new char[board.length][board[0].length()];
        int[] startDir = new int[]{0,0};
        Queue<int[]> queue = new LinkedList();
        for(int i = 0; i < board.length; i ++) {
            cBoard[i] = board[i].toCharArray();
            for(int j = 0; j < cBoard[i].length; j ++) {
                if(cBoard[i][j] == 'R') {
                    startDir = new int[]{i, j, 0};
                }
            }
        }
        queue.add(startDir);
        visited[startDir[0]][startDir[1]] = true;
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int y = node[0];
            int x = node[1];
            int count = node[2];
            if(cBoard[y][x] == 'G') {
                answer = count;
                break;
            }
            for(int[] d : dir) {
                int dy = d[0];
                int dx = d[1];
                int newY = y;
                int newX = x;

                while(true) {
                    if(newY+dy < 0 || newY+dy >= cBoard.length || newX+dx < 0 || newX+dx >= cBoard[0].length || cBoard[newY+dy][newX+dx]=='D') {
                        break;
                    } else {
                        newY += dy;
                        newX += dx;
                    }
                }
                if(!visited[newY][newX]) {
                    queue.add(new int[]{newY, newX, count + 1});
                    visited[newY][newX] = true;
                }
            }
        }
        
        return answer;
    }
}
import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] board = new int[rows][columns];
        int[] answer = new int[queries.length];
        Deque<Integer> deque = new LinkedList();
        int index = 1;
        for(int i = 0; i < rows; i ++) {
            for(int j = 0; j < columns; j ++) {
                board[i][j] = index ++;
            }
        }
        
        for(int k = 0; k < queries.length; k ++) {
            int sx = queries[k][0] - 1;
            int sy = queries[k][1] - 1;
            int ex = queries[k][2] - 1;
            int ey = queries[k][3] - 1;
            for(int i = sy; i < ey; i ++) {
                deque.add(board[sx][i]);
            }
            for(int i = sx; i < ex; i ++) {
                deque.add(board[i][ey]);
            }
            for(int i = ey; i > sy; i --) {
                deque.add(board[ex][i]);
            }
            for(int i = ex; i > sx; i --) {
                deque.add(board[i][sy]);
            }
            deque.addFirst(deque.removeLast());
            int minValue = Integer.MAX_VALUE;
            for(int i = sy; i < ey; i ++) {
                board[sx][i] = deque.poll();
                minValue = Math.min(board[sx][i], minValue);
            }
            for(int i = sx; i < ex; i ++) {
                board[i][ey] = deque.poll();
                minValue = Math.min(board[i][ey], minValue);
            }
            for(int i = ey; i > sy; i --) {
                board[ex][i] = deque.poll();
                minValue = Math.min(board[ex][i], minValue);
            }
            for(int i = ex; i > sx; i --) {
                board[i][sy] = deque.poll();
                minValue = Math.min(board[i][sy], minValue);
            }
            answer[k] = minValue;
            deque.clear();
        }
        return answer;
    }
}
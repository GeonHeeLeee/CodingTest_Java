import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[][] toVisit;
    static boolean[][] visited;
    static int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        toVisit = new int[m][2];

        for(int row = 0; row < n; row ++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < n; col ++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int row = 0; row < m; row ++) {
            st = new StringTokenizer(br.readLine());
            toVisit[row][0] = Integer.parseInt(st.nextToken()) - 1;
            toVisit[row][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        visited = new boolean[n][n];
        int startRow = toVisit[0][0];
        int startCol = toVisit[0][1];
        visited[startRow][startCol] = true;
        Stack<int[]> stack = new Stack();
        stack.push(new int[]{startRow, startCol});
        dfs(startRow, startCol, stack);
        System.out.println(answer);
    }

    public static void dfs(int curRow, int curCol, Stack<int[]> stack) {
        if(curRow == toVisit[m-1][0] && curCol == toVisit[m-1][1]) {
            Stack<int[]> resultStack = (Stack<int[]>) stack.clone();
            resultStack.push(new int[]{curRow, curCol});
            int count = 0;
            for(int idx = m-1; idx >= 0; idx --) {
                int[] goal = toVisit[idx];
                int goalRow = goal[0];
                int goalCol = goal[1];
                while(!resultStack.isEmpty()) {
                    int[] current = resultStack.pop();
                    if(current[0] == goalRow && current[1] == goalCol) {
                        count ++;
                        break;
                    }
                }
            }
            if(count == m) {
                answer ++;
            }
            return;
        }

        for(int[] direction : directions) {
            int dRow = direction[0] + curRow;
            int dCol = direction[1] + curCol;

            if(isInRange(dRow, dCol) && !visited[dRow][dCol] && map[dRow][dCol] == 0) {
                visited[dRow][dCol] = true;
                stack.push(new int[]{dRow, dCol});
                dfs(dRow, dCol, stack);
                stack.pop();
                visited[dRow][dCol] = false;
            }
        }
        
    }

    public static boolean isInRange(int row, int col) {
        return row >= 0 && col >= 0 && row < n && col < n;
    }
}

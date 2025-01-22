import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int l;
    static int r;
    static int openTime = 0;
    static int[][] village;
    static int[][] direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        
        village = new int[n][n];

        for(int row = 0; row < n; row ++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < n; col ++) {
                village[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> queue;
        boolean[][] visited;
        Stack<int[]> stack;
        while(true) {
            queue = new LinkedList<>();
            visited = new boolean[n][n];
            boolean isUnited = false;
            for(int row = 0; row < n; row ++) {
                for(int col = 0; col < n; col ++) {
                    if(!visited[row][col]) {
                        stack = new Stack<>();
                        stack.push(new int[]{row, col});
                        queue.offer(new int[]{row, col, village[row][col]});
                        visited[row][col] = true;
                        int villageCount = 1;
                        int personCount = village[row][col];

                        while(!queue.isEmpty()) {
                            int[] current = queue.poll();
                            for(int[] dir : direction) {
                                int dy = dir[0] + current[0];
                                int dx = dir[1] + current[1];

                                if(dy >= 0 && dy < n && dx >= 0 && dx < n && !visited[dy][dx]) {
                                    int diff = Math.abs(village[dy][dx] - current[2]);
                                    if(diff >= l && diff <= r) {
                                        villageCount ++;
                                        personCount += village[dy][dx];
                                        visited[dy][dx] = true;
                                        stack.add(new int[]{dy, dx});
                                        queue.offer(new int[]{dy, dx, village[dy][dx]});
                                    }
                                }
                                
                            }
                        }
                        if(stack.size() > 1) {
                            isUnited = true;
                            while (!stack.isEmpty()) {
                                int[] current = stack.pop();
                                village[current[0]][current[1]] = personCount / villageCount;
                            }
                        }
                    }
                }
            }
            if(!isUnited) {
                System.out.println(openTime);
                return;
            } else {
                openTime ++;
            }
        }

    }
}

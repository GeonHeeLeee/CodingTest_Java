import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> answer = new ArrayList<>();
        int[][] rectangle = new int[k][4];
        int[][] graph = new int[m][n];
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for(int i = 0; i < k; i ++) {
            st = new StringTokenizer(br.readLine());
            rectangle[i][0] = Integer.parseInt(st.nextToken()); //x1
            rectangle[i][1] = m - Integer.parseInt(st.nextToken()); //y1
            rectangle[i][2] = Integer.parseInt(st.nextToken()); //x2
            rectangle[i][3] = m - Integer.parseInt(st.nextToken()); //y2

            for(int row = rectangle[i][3]; row < rectangle[i][1]; row ++) {
                for(int col = rectangle[i][0]; col < rectangle[i][2]; col ++) {
                    graph[row][col] = -1;
                }
            }
        
        }

        for(int row = 0; row < m; row ++) {
            for(int col = 0; col < n; col ++) {
                if(graph[row][col] != -1) {
                    Queue<int[]> queue = new LinkedList<>();
                    int area = 0;
                    queue.offer(new int[]{row, col});
                    // graph[row][col] = -1;
                    while(!queue.isEmpty()) {
                        int[] current = queue.poll();
                        
                        for(int[] dir : directions) {
                            int dy = dir[0] + current[0];
                            int dx = dir[1] + current[1];
                            
                            if(dy >= 0 && dy < m && dx >= 0 && dx < n && graph[dy][dx] != -1) {
                                queue.offer(new int[]{dy, dx});
                                area += 1;
                                graph[dy][dx] = -1;
                            }
                        }
                    }
                    answer.add(area == 0 ? 1 : area);
                }
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for(int area : answer) {
            System.out.print(area + " ");
        }


        
    }
}

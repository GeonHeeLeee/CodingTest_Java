import java.util.*;
import java.io.*;
public class Main {
    static int lab[][];
    static int n;
    static int m;
    static int maxSafeZone = Integer.MIN_VALUE;
    static int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lab = new int[n][m];

        for(int row = 0; row < n; row ++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < m; col ++) {
                lab[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        placeWalls(0);
        System.out.println(maxSafeZone);
        
    }

    public static void placeWalls(int depth) {
        if(depth == 3) {
            countSafeZone(infectLab());
            return;
        }

        for(int row = 0; row < n; row ++) {
            for(int col = 0; col < m; col ++) {
                if(lab[row][col] == 0) {
                    lab[row][col] = 1;
                    placeWalls(depth+1);
                    lab[row][col] = 0;
                }
            }
        }
    }

    public static int[][] infectLab() {
        int[][] tempLab = copyLab(lab);
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for(int row = 0; row < n; row ++) {
            for(int col = 0; col < m; col ++) {
                if(tempLab[row][col] == 2 && !visited[row][col]) {
                    queue.offer(new int[]{row, col});
                    visited[row][col] = true;

                    while(!queue.isEmpty()) {
                        int[] current = queue.poll();

                        for(int[] dir : directions) {
                            int dy = current[0] + dir[0];
                            int dx = current[1] + dir[1];
                            
                            if(dy >= 0 && dy < n && dx >= 0 && dx < m && !visited[dy][dx] && tempLab[dy][dx] == 0) {
                                tempLab[dy][dx] = 2;
                                visited[dy][dx] = true;
                                queue.offer(new int[]{dy, dx});
                            }
                        }

                    }
                }
            }
        }
        return tempLab;
    }

    public static void countSafeZone(int[][] lab) {
        int safeZone = 0;
        for(int row = 0; row < n; row ++) {
            for(int col = 0; col < m; col ++) {
                if(lab[row][col] == 0) {
                    safeZone ++;
                }
            }
        }
        maxSafeZone = Math.max(safeZone, maxSafeZone);
    }
    public static int[][] copyLab(int[][] lab) {
        int[][] newLab = new int[n][m];
        for(int i = 0; i < n; i ++) {
            newLab[i] = lab[i].clone();
        }
        return newLab;
    }

}

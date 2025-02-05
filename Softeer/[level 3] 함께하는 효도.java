import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] trees;
    static int[][] friends;
    static int[][][] status;
    static int max = Integer.MIN_VALUE;
    static int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        status = new int[n][n][3];
        for(int[][] arr1 : status) {
            for(int[] arr2 : arr1) {
                Arrays.fill(arr2, -1);
            }
        }

        
        trees = new int[n][n];
        friends = new int[m][2];
        
        for(int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j ++) {
                trees[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < m; i ++) {
            st = new StringTokenizer(br.readLine());
            friends[i][0] = Integer.parseInt(st.nextToken()) - 1;
            friends[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        dfs(0, status, 0);
        System.out.println(max);
    }

    public static void dfs(int currentFriend, int[][][] status, int sum) {
        if(currentFriend == m) {

            max = Math.max(sum , max);
            return;
        }
        int startRow = friends[currentFriend][0];
        int startCol = friends[currentFriend][1];
        status[startRow][startCol][currentFriend] = 0;
        if(!isNotCounted(startRow, startCol)) {
            sum += trees[startRow][startCol];
        }
        
        for(int[] direction1 : directions) {
            int d1Row = startRow + direction1[0];
            int d1Col = startCol + direction1[1];
            
            if(isInRange(d1Row, d1Col) && isNotVisited(d1Row, d1Col, 1, currentFriend)) {
                boolean flag1 = false;
                if(isNotCounted(d1Row, d1Col)) {
                    flag1 = true;
                    sum += trees[d1Row][d1Col];
                }
                status[d1Row][d1Col][currentFriend] = 1;
                for(int[] direction2 : directions) {
                    int d2Row = d1Row + direction2[0];
                    int d2Col = d1Col + direction2[1];
                    if(isInRange(d2Row, d2Col) && isNotVisited(d2Row, d2Col, 2, currentFriend)) {
                        boolean flag2 = false;
                        if(isNotCounted(d2Row, d2Col)) {
                            flag2 = true;
                            sum += trees[d2Row][d2Col];
                        }
                        status[d2Row][d2Col][currentFriend] = 2;
                        
                        for(int[] direction3 : directions) {
                            int d3Row = d2Row + direction3[0];
                            int d3Col = d2Col + direction3[1];
                            if(isInRange(d3Row, d3Col) && isNotVisited(d3Row, d3Col, 3, currentFriend)) {
                                boolean flag3 = false;
                                if(isNotCounted(d3Row, d3Col)) {
                                    flag3 = true;
                                    sum += trees[d3Row][d3Col];
                                }
                                status[d3Row][d3Col][currentFriend] = 3;
                                dfs(currentFriend + 1, status, sum);
                                if(flag3) {
                                    sum -= trees[d3Row][d3Col];
                                }
                                status[d3Row][d3Col][currentFriend] = -1;
                            }
                        }
                        if(flag2) {
                            sum -= trees[d2Row][d2Col];
                        }
                        status[d2Row][d2Col][currentFriend] = -1;  
                    }
                }
                if(flag1) {
                    sum -= trees[d1Row][d1Col];
                }
                status[d1Row][d1Col][currentFriend] = -1;
            }


        }

    }

    public static boolean isInRange(int row, int col) {
        return row >= 0 && col >= 0 && row < n && col < n;
    }

    public static boolean isNotVisited(int row, int col, int time, int currentFriend) {
        return status[row][col][0] != time && status[row][col][1] != time && status[row][col][2] != time && status[row][col][currentFriend] == -1;
    }
    
    public static boolean isNotCounted(int row, int col) {
        return status[row][col][0] == -1 && status[row][col][1] == -1 && status[row][col][2] == -1;
    }
}

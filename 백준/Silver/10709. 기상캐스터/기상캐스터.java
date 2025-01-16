import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] cloud = new int[h][w];
        int[][] answer = new int[h][w];

        for(int row = 0; row < h; row ++) {
            char[] inputChar = br.readLine().toCharArray();
            for(int col = 0; col < w; col ++) {
                if(inputChar[col] == 'c') {
                    cloud[row][col] = 1;
                    answer[row][col] = 0;
                } else {
                    answer[row][col] = Integer.MAX_VALUE;
                }
            }
        }

        for(int row = 0; row < h; row ++) {
            for(int col = 0; col < w; col ++) {
                if(cloud[row][col] == 1) {
                    int count = 1;
                    for(int idx = col + 1; idx < w; idx ++) {
                        answer[row][idx] = Math.min(answer[row][idx], count);
                        count ++;
                    }
                }
            }

            for(int col = 0; col < w; col ++) {
                if(answer[row][col] == Integer.MAX_VALUE) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(answer[row][col] + " ");
                }
            }
            System.out.println();
        }
    }
}

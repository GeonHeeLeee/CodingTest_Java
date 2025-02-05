import java.io.*;
import java.util.*;

public class Main {
    static int[][] land = new int[3][3];
    static double[] vertical = new double[3]; //수직
    static double[] horizontal = new double[3]; //수평
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int row = 0; row < 3; row ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double sum = 0;
            for(int col = 0; col < 3; col ++) {
                land[row][col] = Integer.parseInt(st.nextToken());
                sum += land[row][col];
            }
            sum = sum / 3;
            for(int col = 0; col < 3; col ++) {
                horizontal[row] += Math.abs(sum - (double) land[row][col]);
            }
            min = Math.min((int) horizontal[row], min);
        }

        for(int row = 0; row < 3; row ++) {
            double sum = 0;
            for(int col = 0; col < 3; col ++) {
                sum += land[col][row];
            }
            sum = sum / 3;
            for(int col = 0; col < 3; col ++) {
                vertical[row] += Math.abs(sum - (double) land[col][row]);
            }
            min = Math.min((int) vertical[row], min);
        }

        System.out.println(min);
    }
}

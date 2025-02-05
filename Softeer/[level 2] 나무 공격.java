import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] input;
        int[][] wood = new int[n][m];
        int people = 0;
        for(int row = 0; row < n; row ++) {
            input = br.readLine().split(" ");
            for(int col = 0; col < m; col ++) {
                wood[row][col] = Integer.parseInt(input[col]);
                if(wood[row][col] == 1) {
                    people ++;
                }
            }
        }

        int[][] attacks = new int[2][2];
        input = br.readLine().split(" ");
        attacks[0][0] = Integer.parseInt(input[0]) - 1;
        attacks[0][1] = Integer.parseInt(input[1]) - 1;
        
        input = br.readLine().split(" ");
        attacks[1][0] = Integer.parseInt(input[0]) - 1;
        attacks[1][1] = Integer.parseInt(input[1]) - 1;

        for(int[] attack : attacks) {
            int start = attack[0];
            int end = attack[1];
            for(int row = start; row <= end; row ++) {
                for(int col = 0; col < m; col ++) {
                    if(wood[row][col] == 1) {
                        people --;
                        wood[row][col] = 0;
                        break;
                    }
                }    
            }
        }

        System.out.println(people);
        
    }
}

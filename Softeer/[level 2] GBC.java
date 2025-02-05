import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] limits = new int[n][2];
        int[][] tests = new int[m][2];
        for(int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for(int idx = 0; idx < 2; idx ++) {
                if(idx == 0) {
                    if(i == 0) {
                        limits[0][0] = Integer.parseInt(st.nextToken());
                    } else {
                        limits[i][0] = limits[i-1][0] + Integer.parseInt(st.nextToken());
                    }
                    continue;
                }
                limits[i][1] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < m; i ++) {
            st = new StringTokenizer(br.readLine());
            for(int idx = 0; idx < 2; idx ++) {
                if(idx == 0) {
                    if(i == 0) {
                        tests[0][0] = Integer.parseInt(st.nextToken());
                    } else {
                        tests[i][0] = tests[i-1][0] + Integer.parseInt(st.nextToken());
                    }
                    continue;
                }
                tests[i][idx] = Integer.parseInt(st.nextToken());
            }
        }
        
        int maxSpeed = 0;
        for(int l = 0; l < n; l ++) {
            int beforeLimit = 0;
            if(l > 0) {
                beforeLimit = limits[l-1][0];
            }
            int lengthLimit = limits[l][0];
            int speedLimit = limits[l][1];

            for(int t = 0; t < m; t++) {
                int startTest = 0;
                if(t > 0) {
                    startTest = tests[t-1][0];
                }
                int testLength = tests[t][0];
                int testSpeed = tests[t][1];
                
                if(beforeLimit < testLength && startTest < lengthLimit) {
                    if(speedLimit <= testSpeed) {
                        maxSpeed = Math.max(testSpeed - speedLimit, maxSpeed);
                    }
                }
            }
        }

        System.out.println(maxSpeed);
    }
}

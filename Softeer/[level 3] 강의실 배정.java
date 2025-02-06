import java.io.*;
import java.util.*;

public class Main {
    static int[][] courses;
    static int n;
    static int answer = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        courses = new int[n][2];
        
        for(int idx = 0; idx < n; idx ++) {
            st = new StringTokenizer(br.readLine());
            courses[idx][0] = Integer.parseInt(st.nextToken()) - 1;
            courses[idx][1] = Integer.parseInt(st.nextToken()) - 1;
        }
        Arrays.sort(courses, (a,b) -> a[1] - b[1]);
        
        int[] dp = new int[n];
        int lastEndTime = -1;
        
        for(int idx = 0; idx < n; idx ++) {
            if(lastEndTime <= courses[idx][0]) {
                answer ++;
                lastEndTime = courses[idx][1];
            }
        }

        System.out.println(answer);
    }
    
}

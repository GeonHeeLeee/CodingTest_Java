import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());
        int[] apple = new int[j];

        int startM = 0;
        int endM = m-1;
        int move = 0;
        for(int idx = 0; idx < j; idx ++) {
            
            apple[idx] = Integer.parseInt(br.readLine()) - 1;
            if(apple[idx] < startM) {
                move += startM - apple[idx];
                startM = apple[idx];
                endM = startM + m-1;
            } else if(endM < apple[idx]) {
                move += apple[idx] - endM;
                endM = apple[idx];
                startM = endM - (m-1);
            }
        }
        System.out.println(move);
    }
}

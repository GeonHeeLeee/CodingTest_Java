import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] park = new int[101];

        for(int i = 0; i < 3; i ++) {
            st = new StringTokenizer(br.readLine());
            int arrived = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());

            for(int time = arrived; time < left; time ++) {
                park[time] += 1;
            }
        }

        int fee = 0;

        for(int i = 0; i < 101; i ++) {
            if(park[i] == 1) {
                fee += a;        
            } else if(park[i] == 2) {
                fee += b * 2;
            } else if(park[i] == 3) {
                fee += c * 3;
            }
        }

        System.out.println(fee);
    }
}
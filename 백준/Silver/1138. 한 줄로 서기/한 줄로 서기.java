import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] line = new int[n];
        int index = 0;
        while(st.hasMoreTokens()) {
            line[index++] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[n];
        for(int idx = 0; idx < n; idx ++) {
            int count = 0;
            while(count < n) {
                if(answer[count] == 0 && line[idx] == 0) {
                    break;
                }

                if(answer[count] == 0) {
                    line[idx] --;
                }
                count ++;
            }
            answer[count] = idx + 1;
        }
        for(int i : answer) {
            System.out.print(i + " ");
        }
    }
}
import java.io.*;
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] counts = new int[10001];
        for(int idx = 0; idx < n; idx ++) {
            int num = Integer.parseInt(br.readLine());
            counts[num] ++;
        }

        for(int idx = 1; idx < 10001; idx ++) {
            while(counts[idx] > 0) {
                sb.append(idx).append('\n');
                counts[idx] --;
            }
        }
        System.out.print(sb.toString());
    }
}

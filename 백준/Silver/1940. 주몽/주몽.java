import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] ingredients = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int idx = 0; idx < n; idx ++) {
            ingredients[idx] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ingredients);
        int curLastIdx = n-1;
        int answer = 0;

        for(int idx = 0; idx < n; idx ++) {
            for(int lastIdx = curLastIdx; lastIdx >= 0; lastIdx --) {
                int firstIgdt = ingredients[idx];
                int lastIgdt = ingredients[lastIdx];
                if(firstIgdt + lastIgdt == m) {
                    answer ++;
                } else if(firstIgdt + lastIgdt > m) {
                    curLastIdx = lastIdx;
                } 
            }
        }
        System.out.println(answer/2);
    }    
}

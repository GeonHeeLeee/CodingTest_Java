import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] w;
    static int best = 0;
    static Map<Integer, List<Integer>> friendMap = new HashMap();;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i ++) {
            friendMap.put(i, new ArrayList());
        }
        w = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i ++) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i ++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            friendMap.get(a).add(b);
            friendMap.get(b).add(a);
        }
        
        for(int me : friendMap.keySet()) {
            List<Integer> friendList = friendMap.get(me);
            boolean isBest = true;
            for(int friend : friendList) {
                if(w[friend] >= w[me]) {
                    isBest = false;
                    break;
                }
            }
            if(isBest) {
                best ++;
            }
        }
        System.out.println(best);
    }
}

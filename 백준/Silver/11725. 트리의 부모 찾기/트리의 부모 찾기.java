import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        TreeMap<Integer, List<Integer>> tree = new TreeMap<>();
        
        for(int i = 1; i <= n; i ++) {
            tree.put(i, new ArrayList());
        }

        for(int idx = 0; idx < n - 1; idx ++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            tree.get(parent).add(child);
            tree.get(child).add(parent);
        }
    
        int[] rootList = new int[n+1];
        Queue<Integer> queue = new LinkedList();
        queue.add(1);
        while(!queue.isEmpty()) {
            int curNode = queue.poll();
            List<Integer> children = tree.get(curNode);
            for(int child : children) {
                if(rootList[child] == 0) {
                    rootList[child] = curNode;
                    queue.add(child);
                }
            }
        }
        for(int idx = 2; idx < n+1; idx ++) {
            System.out.println(rootList[idx]);
        }

    }
}
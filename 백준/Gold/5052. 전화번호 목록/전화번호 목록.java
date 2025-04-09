import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int trial = 0; trial < t; trial++) {
            int n = Integer.parseInt(br.readLine());

            String[] nums = new String[n];
            for (int i = 0; i < n; i++) {
                nums[i] = br.readLine();
            }

            Arrays.sort(nums);
            boolean found = false;
            for(int i = 0; i < n - 1; i ++) {
                if(nums[i+1].startsWith(nums[i])) {
                    System.out.println("NO");
                    found = true;
                    break;
                }
            }

            if(!found) {
                System.out.println("YES");
            }

        }
    }
}
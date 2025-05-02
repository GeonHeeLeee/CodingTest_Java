import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        Map<Integer, Integer> numMap = new HashMap();
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        int max = 0;
        int maxKey = 0;
        for (int key : numMap.keySet()) {
            if (numMap.get(key) > max) {
                max = numMap.get(key);
                maxKey = key;
            }
        }
        System.out.println(sum / 10);
        System.out.println(maxKey);

    }
}
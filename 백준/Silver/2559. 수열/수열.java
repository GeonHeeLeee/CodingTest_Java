import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] temp = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        int first = 0;
        int last = k - 1;
        int maxTemp = 0;

        for (int i = first; i <= last; i++) {
            maxTemp += temp[i];
        }

        int answer = maxTemp;

        while (last < n - 1) {
            maxTemp = maxTemp - temp[first] + temp[last + 1];
            first += 1;
            last += 1;
            answer = Math.max(answer, maxTemp);
        }
        System.out.println(answer);
    }
}
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] houses = new int[n];

        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        int first = 1;
        int last = houses[n - 1];

        while (first <= last) {
            int mid = (first + last) / 2;

            int position = 0;
            int count = 1;

            for (int i = 1; i < n; i++) {
                if (houses[i] - houses[position] >= mid) {
                    position = i;
                    count++;
                }
            }

            if (count < c) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        System.out.println(first - 1);
    }
}
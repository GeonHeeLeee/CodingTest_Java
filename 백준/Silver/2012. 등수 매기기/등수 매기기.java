import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ranks = new int[n];

        for (int i = 0; i < n; i++) {
            ranks[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ranks);

        int realRank = 1;
        long answer = 0;

        for(int rank : ranks) {
            answer += Math.abs(realRank - rank);
            realRank ++;
        }


        System.out.println(answer);
    }
}
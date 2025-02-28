import java.io.*;
import java.util.*;

class Main {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        while(pq.size() >= 2) {
            int card1 = pq.poll();
            int card2 = pq.poll();
            sum += (card1 + card2);
            pq.offer(card1 + card2);

        }

        System.out.println(sum);

    }

}
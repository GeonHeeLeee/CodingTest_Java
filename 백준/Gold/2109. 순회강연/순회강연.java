import java.io.*;
import java.util.*;

public class Main {
    static class Lecture {
        int p;
        int d;

        public Lecture(int p, int d) {
            this.p = p;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        List<Lecture> lectureList = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int maxDay = 0;
        int money = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            maxDay = Math.max(maxDay, d);
            lectureList.add(new Lecture(p, d));
        }
        lectureList.sort((a,b) -> b.d - a.d);

        int index = 0;
        for(int day = maxDay; day > 0; day --) {
            while(index < n && lectureList.get(index).d >= day) {
                pq.offer(lectureList.get(index).p);
                index ++;
            }
            if(!pq.isEmpty()) {
                money += pq.poll();
            }
        }
        System.out.println(money);
    }
}

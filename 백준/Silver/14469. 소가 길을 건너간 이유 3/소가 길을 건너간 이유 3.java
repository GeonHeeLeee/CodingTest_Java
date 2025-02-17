import java.io.*;
import java.util.*;

public class Main {

    static class Cow {
        int arrived;
        int check;

        public Cow(int arrived, int check) {
            this.arrived = arrived;
            this.check = check;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Cow> cowList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cowList.add(new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        cowList.sort((a, b) -> (a.arrived - b.arrived));

        int time = 0;
        for (int i = 0; i < n; i++) {
            Cow cow = cowList.get(i);

            if (time <= cow.arrived) {
                time = cow.arrived + cow.check;
            } else {
                time = time + cow.check;
            }
        }
        System.out.println(time);
    }
}

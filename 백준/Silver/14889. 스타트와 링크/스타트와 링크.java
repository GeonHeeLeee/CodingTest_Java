import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int min = Integer.MAX_VALUE;
    static int[][] power;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        power = new int[n][n];

        for(int row = 0; row < n; row ++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < n; col ++) {
                power[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(new HashSet<>(), 0);
        System.out.println(min);

    }
    public static void dfs(Set<Integer> players, int index) {
        if(players.size() == n / 2) {
            int startTeam = 0;
            int linkTeam = 0;
            for(int row = 0; row < n; row ++) {
                for(int col = 0; col < n; col ++) {
                    if(row != col && players.contains(row) && players.contains(col)) {
                        startTeam += power[row][col];
                    } else if(row != col && !players.contains(row) && !players.contains(col)) {
                        linkTeam += power[row][col];
                    }
                }
            }
            min = Math.min(min, Math.abs(startTeam - linkTeam));
            return;
        }
        if(index >= n) {
            return;
        }
        players.add(index);
        dfs(players, index + 1);
        players.remove(index);
        dfs(players, index + 1);
    }
}

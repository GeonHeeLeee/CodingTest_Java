import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int m;
    static int minChickenLength = Integer.MAX_VALUE;
    static List<int[]> chickenList = new ArrayList<>();
    static List<int[]> houseList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int value;
        for(int row = 0; row < n; row ++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < n; col ++) {
                value = Integer.parseInt(st.nextToken());
                if(value == 2) {
                    chickenList.add(new int[]{row, col});
                } else if(value == 1) {
                    houseList.add(new int[]{row, col});
                }
            }
        }

        dfs(0, 0, new ArrayList<>());
        System.out.println(minChickenLength);
    }

    public static void countChickenLength(List<int[]> selected) {
        int totalLength = 0;
        for(int[] house : houseList) {
            int minLength = Integer.MAX_VALUE;
            for(int[] chicken : selected) {
                minLength = Math.min(minLength, Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]));
            }
            totalLength += minLength;
        }
        minChickenLength = Math.min(totalLength, minChickenLength);
        return;
    }

    public static void dfs(int chickenCount, int index, List<int[]> selected) {
        if(chickenCount == m) {
            countChickenLength(selected);
            return;
        }

        for(int idx = index; idx < chickenList.size(); idx ++) {
            selected.add(chickenList.get(idx));
            dfs(chickenCount + 1, idx + 1, selected);
            selected.remove(selected.size() - 1);
        }        
    }
}

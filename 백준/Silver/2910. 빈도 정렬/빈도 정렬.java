import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> indexMap = new HashMap<>();
        Map<Integer, Integer> numberMap = new HashMap<>();
        for(int i = 0; i < n; i ++) {
            int num = Integer.parseInt(st.nextToken());
            if(!indexMap.containsKey(num)) {
                indexMap.put(num, i);
            }
            numberMap.put(num, numberMap.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(numberMap.entrySet());
        entryList.sort((e1, e2) -> {
            int valueCompare = e2.getValue() - e1.getValue();
            if(valueCompare != 0) {
                return valueCompare;
            }
            return indexMap.get(e1.getKey()) - indexMap.get(e2.getKey());
        });
        
        for(Map.Entry<Integer, Integer> entry : entryList) {
            for(int i = 0; i < entry.getValue(); i ++) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}

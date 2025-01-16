import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> numList = new ArrayList<>();
        for(int i = 0; i < n; i ++) {
            String input = br.readLine();
            String[] splitStr = input.split("[^0-9]");
            for(String str : splitStr) {
                if(!str.isEmpty() && !str.isBlank()) {
                    str = str.replaceFirst("^0+", "");
                    if(str.isEmpty()) {
                        str = "0";
                    }
                    numList.add(str);
                }
            }
        }
        Collections.sort(numList, (n1, n2) -> {
            int l1 = ((String) n1).length();
            int l2 = ((String) n2).length();
            int result = l1 - l2;
            if(result != 0) {
                return result;
            }
            return n1.compareTo(n2);
        });
        for(String num : numList) {
            System.out.println(num);
        }
    }
}

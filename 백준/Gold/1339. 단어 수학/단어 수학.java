import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Double> alphaMap = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        String[] input = new String[n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            char[] arr = str.toCharArray();
            input[i] = str;
            for (int idx = 0; idx < arr.length; idx++) {
                char letter = arr[idx];
                if (!alphaMap.containsKey(letter)) {
                    alphaMap.put(letter, Math.pow(10, arr.length - idx));
                } else {
                    alphaMap.put(letter, alphaMap.get(letter) + Math.pow(10, arr.length - idx));
                }
            }
        }

        List<Map.Entry<Character, Double>> entryList = new ArrayList<>(alphaMap.entrySet());
        entryList.sort(Map.Entry.<Character, Double>comparingByValue().reversed());

        Map<Character, Integer> rankMap = new HashMap<>();
        int rank = 9;

        for (Map.Entry<Character, Double> entry : entryList) {
            rankMap.put(entry.getKey(), rank--);
        }

        int answer = 0;

        for (String str : input) {
            for (int idx = 0; idx < str.length(); idx++) {
                answer += rankMap.get(str.charAt(idx)) * (int) Math.pow(10, str.length() - 1 - idx);
            }
        }
        System.out.println(answer);
    }
}
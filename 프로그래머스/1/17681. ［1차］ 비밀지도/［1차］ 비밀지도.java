import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        List<String> map = new ArrayList();
        for(int i = 0; i < n; i ++) {
            String a = Integer.toBinaryString(arr1[i] | arr2[i]);
            String answer = String.format("%"+n+"s", a).replaceAll("1", "#").replaceAll("0", " ");
            map.add(answer);
        }
        return map.toArray(new String[0]);
    }
}
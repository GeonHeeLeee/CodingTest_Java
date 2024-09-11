import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> set1 = new ArrayList();
        List<String> set2 = new ArrayList();
        List<String> intersect = new ArrayList();
        List<String> union = new ArrayList();
        
        for(int i = 0; i < str1.length()-1; i ++) {
            String subStr = str1.substring(i,i+2);
            if(subStr.matches("[A-Za-z]+")) {
                set1.add(subStr.toLowerCase());
            }
        }
        for(int i = 0; i < str2.length()-1; i ++) {
            String subStr =str2.substring(i,i+2);
            if(subStr.matches("[A-Za-z]+")) {
                set2.add(subStr.toLowerCase());
                if(!set1.contains(subStr.toLowerCase())) {
                    union.add(subStr.toLowerCase());
                }
            }

        }
        for(int i = 0; i < set1.size(); i ++) {
            String letter = set1.get(i);
            if(set2.contains(letter)) {
                int countInSet1 = Collections.frequency(set1, letter);
                int countInSet2 = Collections.frequency(set2, letter);
                
                int max = Math.max(countInSet1, countInSet2);
                int min = Math.min(countInSet1, countInSet2);
                
                if(!union.contains(letter)) {
                    for(int k = 0; k < max; k ++) {
                        union.add(letter);
                    }
                }
                if(!intersect.contains(letter)) {
                    for(int j = 0; j < min; j ++) {
                        intersect.add(letter);
                    }
                }

            } else {
                union.add(letter);
            }
            
        }
        System.out.println(set1);
        System.out.println(set2);
        System.out.println("Union: " + union);
        System.out.println("Intersect: "+ intersect);
        if(set1.size() == 0 && set2.size() == 0) {
            return 1 * 65536;
        }
        return (int) ((double) intersect.size() / union.size() * 65536);
    }
}
import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int count = 0;
        int[] answer = new int[]{0,0};
        List<String> spokenWord = new ArrayList();
        spokenWord.add(words[0]);
        int personNum = 0;
        char beforeLetter = words[0].charAt(words[0].length() - 1);
        
        
        
        
        for(int i = 1; i < words.length; i ++) {
            personNum = (i % n) + 1;
            char firstLetter = words[i].charAt(0);
            if(beforeLetter == firstLetter && !spokenWord.contains(words[i])) {
                beforeLetter = words[i].charAt(words[i].length() - 1);
                spokenWord.add(words[i]);
            } else {
                count = i + 1;
                break;
            }
        }
        if(spokenWord.size() == words.length) {
            return answer;
        }
        answer = new int[]{personNum, count%n == 0 ? count/n : count/n + 1};
        return answer;
    }
}
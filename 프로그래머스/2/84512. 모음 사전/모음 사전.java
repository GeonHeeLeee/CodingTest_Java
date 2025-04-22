import java.util.*;
class Solution {
    Set<String> tempDictionary = new HashSet<>();
    public int solution(String word) {
        int answer = 0;
        char[] vowels = new char[]{'A', 'E', 'I', 'O','U'};
        makeWords(vowels, new StringBuilder());
        List<String> dictionary = new ArrayList<>(tempDictionary);
        Collections.sort(dictionary);
        return dictionary.indexOf(word) + 1;
        
    }
    
    public void makeWords(char[] letters, StringBuilder sb) {
        if(sb.length() == 5) {
            return;
        }
        
        for(int i = 0; i < letters.length; i ++) {
            sb.append(letters[i]);
            tempDictionary.add(sb.toString());
            makeWords(letters, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
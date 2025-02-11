import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        List<Integer> answer = new ArrayList();
        Map<Character, Integer> keyResult = new HashMap();
        for(String key : keymap) {
            char[] keySplit = key.toCharArray();
            for(int i = 0; i < keySplit.length; i ++) {
                if(!keyResult.containsKey(keySplit[i])) {
                    keyResult.put(keySplit[i], i+1);
                } else {
                    keyResult.put(keySplit[i], Math.min(i+1, keyResult.get(keySplit[i])));
                }
            }
        }
        for(String key : targets) {
            char[] keySplit = key.toCharArray();
            int count = 0;
            for(char letter : keySplit) {
                if(keyResult.containsKey(letter)) {
                    count += keyResult.get(letter);
                } else {
                    count = -1;
                    break;
                }
            }
            answer.add(count);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
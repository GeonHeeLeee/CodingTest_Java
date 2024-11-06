import java.util.*;
class Word {
    String word;
    int count;
    
    public Word(String word, int count) {
        this.word = word;
        this.count = count;
    }
}
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Word> queue = new LinkedList();
        boolean[] visited = new boolean[words.length];
        int minCount = Integer.MAX_VALUE;
        
        queue.add(new Word(begin, 0));
        
        while(!queue.isEmpty()) {
            Word node = queue.poll();
            String word = node.word;
            int count = node.count;
            if(word.equals(target)) {
                minCount = Math.min(minCount, count);
            }
            for(int i = 0; i < words.length; i ++) {
                if(isSimilar(words[i], word) && !visited[i]) {
                    queue.add(new Word(words[i], count + 1));
                    visited[i] = true;
                }
            }
        }
        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }
    
    public boolean isSimilar(String s1, String s2) {
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        int diffCount = 0;
        for(int i = 0; i < char1.length; i ++) {
            if(char1[i] != char2[i]) {
                diffCount ++;
                if(diffCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
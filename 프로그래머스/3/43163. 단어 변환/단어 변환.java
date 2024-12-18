import java.util.*;
class Solution {
    class Word {
        String word;
        int count;
        
        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
        
        public boolean isSimilar(String word2) {
            int count = 0;
            for(int idx = 0; idx < word2.length(); idx++) {
                if(this.word.charAt(idx) != word2.charAt(idx)) {
                    count ++;
                    if(count > 1) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<Word> queue = new LinkedList();
        Word beginWord = new Word(begin, 0);
        queue.offer(beginWord);
        
        while(!queue.isEmpty()) {
            Word curWord = queue.poll();
            String word = curWord.word;
            int count = curWord.count;
            
            for(int idx = 0; idx < words.length; idx ++) {
                String nextWord = words[idx];
                if(curWord.isSimilar(nextWord) && !visited[idx]) {
                    if(nextWord.equals(target)) {
                        return count + 1;
                    }
                    queue.offer(new Word(nextWord, count + 1));
                    visited[idx] = true;
                }
            }
        }
        return 0;
    }

}
import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int n = citations.length;
        int max = citations[n - 1];
        
        for(int h = 0; h <= max; h ++) {
            int quoteCount = 0;
            int notQuoteCount = 0;
            for(int citation : citations) {
                if(citation >= h) {
                    quoteCount ++;
                } else if(citation <= h) {
                    notQuoteCount ++;
                }
            }
            
            if(quoteCount >= h && notQuoteCount <= h) {
                answer = h;
            }
        }
        return answer;
    }
}
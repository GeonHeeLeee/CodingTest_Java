import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> resultMap = new HashMap();
        Map<String, Integer> jisoo = new HashMap();
        Map<String, Map<String, Integer>> giftMap = new HashMap();
        
        for(String self : friends) {
            Map<String, Integer> otherMap = new HashMap();
            for(String other : friends) {
                if(!self.equals(other)) {
                    otherMap.put(other, 0);
                }
            }
            resultMap.put(self, 0);
            giftMap.put(self, otherMap);
            jisoo.put(self, 0);
        }
        for(String names : gifts) {
            String self = names.split(" ")[0];
            String other = names.split(" ")[1];
            
            giftMap.get(self).put(other, giftMap.get(self).get(other) + 1);
            jisoo.put(self, jisoo.get(self) + 1);
            jisoo.put(other, jisoo.get(other) - 1);
        }

        for(String sender : giftMap.keySet()) {
            Map<String, Integer> receiveMap = giftMap.get(sender);
            for(String receiver : giftMap.get(sender).keySet()) {
                int senderSent = giftMap.get(sender).get(receiver);
                int receiverSent = giftMap.get(receiver).get(sender);
                if(senderSent == receiverSent) {
                    int senderJisoo = jisoo.get(sender);
                    int receiverJisoo = jisoo.get(receiver);
                    if(senderJisoo > receiverJisoo) {
                        resultMap.put(sender, resultMap.get(sender) + 1);
                    } else if(senderJisoo < receiverJisoo) {
                        resultMap.put(receiver, resultMap.get(receiver) + 1);
                    }
                } else {
                    if(senderSent < receiverSent) {
                        resultMap.put(receiver, resultMap.get(receiver) + 1);
                    } else {
                        resultMap.put(sender, resultMap.get(sender) + 1);
                    }
                
                }
                giftMap.get(receiver).remove(sender);
            }
            
        }        
        
        return resultMap.values().stream().max(Integer::compare).get();
    }
}
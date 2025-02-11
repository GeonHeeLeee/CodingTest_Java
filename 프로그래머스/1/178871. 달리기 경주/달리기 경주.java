import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerMap = new HashMap();
        for(int i = 0; i < players.length; i ++) {
            playerMap.put(players[i],i);
        }
        
        for(int i = 0; i < callings.length; i ++) {
            int calledPlayerIndex = playerMap.get(callings[i]);
            int passedPlayerIndex = playerMap.get(players[calledPlayerIndex - 1]);
            playerMap.put(players[calledPlayerIndex], calledPlayerIndex - 1);
            playerMap.put(players[passedPlayerIndex], calledPlayerIndex);
            
            players[calledPlayerIndex] = players[passedPlayerIndex];
            players[passedPlayerIndex] = callings[i];
        }
        return players;
    }
}
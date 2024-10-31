import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList();
        for(int i = 0; i < bridge_length; i ++) {
            bridge.add(0);
        }
        
        int currentWeight = 0;
        int index = 0;
        int time = 0;
        
        while(index < truck_weights.length || currentWeight > 0) {
            time ++;
            
            currentWeight -= bridge.poll();
            
            if(index < truck_weights.length && currentWeight + truck_weights[index] <= weight) {
                bridge.add(truck_weights[index]);
                currentWeight += truck_weights[index++];
            } else {
                bridge.add(0);
            }
        }
        
        return time;
    }
}
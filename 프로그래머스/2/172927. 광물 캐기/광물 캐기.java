import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int pickSum = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> Integer.compare(b[0], a[0]));
        for(int pick : picks) {
            pickSum += pick * 5;
        }
        int length = (int) Math.min(minerals.length, pickSum);
        int weightSum = 0;
        for(int i = 0; i < length; i ++) {
            int weight = 0;
            switch(minerals[i]) {
                case "diamond":
                    weight = 25;
                    break;
                case "iron":
                    weight = 5;
                    break;
                case "stone":
                    weight = 1;
                    break;
            }
            weightSum += weight;
            if((i+1) % 5 == 0 || i == length-1) {
                pq.add(new int[]{weightSum, i/5});
                weightSum = 0;
            }
        }
        
        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int value = node[0];
            int index = node[1];
            int pickIdx = 0;
            for(int j = 0; j < 3; j ++) {
                if(picks[j] != 0) {
                    pickIdx = j;
                    picks[j] --;
                    break;
                }
            }
            for(int i = index * 5; i < index * 5 + 5; i ++) {
                if(i == minerals.length) {
                    break;
                }
                if(pickIdx == 0) {
                    answer ++;
                } else if(pickIdx == 1) {
                    if(minerals[i].equals("diamond")) {
                        answer += 5;
                    } else {
                        answer ++;
                    }
                } else {
                    if(minerals[i].equals("diamond")) {
                        answer += 25;
                    } else if(minerals[i].equals("iron")) {
                        answer += 5;
                    } else {
                        answer ++;
                    }
                }
            }
        }
        return answer;
    }
}
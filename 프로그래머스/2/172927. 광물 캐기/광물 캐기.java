import java.util.*;
class Solution {
    int tired = 0;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int pickCount = 0;
        int mineralCount = minerals.length;
        
        for(int pick : picks) {
            pickCount += pick;
        }
        
        pickCount *= 5;
        
        List<int[]> tireds = new ArrayList<>();
        
        int max = pickCount <= mineralCount ? pickCount : mineralCount;
        for(int i = 0; i < max; i += 5) {
            int stoneSum = 0;
            int ironSum = 0;
            int diaSum = 0;
            for(int j = i; j < (int) Math.min(i + 5, max); j ++) {
                stoneSum += stoneMineral(minerals[j]);
                ironSum += ironMineral(minerals[j]);
                diaSum += diaMineral(minerals[j]);
            }
            tireds.add(new int[]{diaSum, ironSum, stoneSum});
        }
        
        Collections.sort(tireds, (a,b) -> b[2] - a[2]);

        for(int[] current : tireds) {
            for(int i = 0; i < 3; i ++) {
                if(picks[i] > 0) {
                    answer += current[i];
                    picks[i] --;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    public int diaMineral(String mineral) {
        return 1;
    }
    
    public int ironMineral(String mineral) {
        if(mineral.equals("diamond")) {
            return 5;
        }
        return 1;
    }
    
    public int stoneMineral(String mineral) {
        if(mineral.equals("diamond")) {
            return 25;
        } else if(mineral.equals("iron")) {
            return 5;
        }
        return 1;
    }
}
import java.util.*;
import java.time.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        TreeMap<String, Integer> feeMap = new TreeMap();
        HashMap<String, LocalTime> inOutMap = new HashMap();
        for(String input : records) {
            String[] record = input.split(" ");
            if(record[2].equals("IN")) {
                inOutMap.put(record[1], LocalTime.parse(record[0]));
            } else {
                int minute = (int) Duration.between(inOutMap.get(record[1]),LocalTime.parse(record[0])).toMinutes();
                feeMap.put(record[1], feeMap.getOrDefault(record[1], 0) + minute);
                inOutMap.remove(record[1]);
            }
        }
        for(String key : inOutMap.keySet()) {
            int minute = (int) Duration.between(inOutMap.get(key),LocalTime.parse("23:59")).toMinutes();
            feeMap.put(key, feeMap.getOrDefault(key, 0) + minute);
        }

        for(String key : feeMap.keySet()) {
            int minute = feeMap.get(key);
            if(minute <= fees[0]) {
                feeMap.put(key, fees[1]);
            } else {
                feeMap.put(key, fees[1] + (int) Math.ceil((minute - fees[0]) / (double)fees[2])*fees[3]);
            }
        }

        return feeMap.values().stream().mapToInt(i->i).toArray();
    }
}
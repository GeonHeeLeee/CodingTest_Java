import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> lotto = Arrays.stream(lottos).boxed().collect(Collectors.toList());
        List<Integer> winNums = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
        int zeros = 0;
        int match = 0;
        for(int num : lotto) {
            if(winNums.contains(num)) {
                match ++;
            }
            if(num == 0) {
                zeros ++;
            }
        }

        int[] an = {match + zeros == 0 ? 6 :7 - (match + zeros), 7 - ((match == 0) ? 1 : match)};
        return an;
    }
}
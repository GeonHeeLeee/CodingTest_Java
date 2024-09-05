import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int lightest = 0;
        int heaviest = people.length - 1;
        while(lightest <= heaviest) {
            if(people[lightest] + people[heaviest] <= limit) {
                lightest ++;
            }
            heaviest --; //가장 몸무게 적은 사람이랑 해도 못타면 어차피 못타는거
            answer++; //뚱뚱한 사람 보내기
        }
        return answer;
    }
}
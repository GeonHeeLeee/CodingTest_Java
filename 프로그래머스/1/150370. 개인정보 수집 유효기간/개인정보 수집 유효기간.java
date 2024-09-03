import java.util.*;
import java.util.stream.*;
import java.time.LocalDate;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList();
        Map<String, Integer> termMap = new HashMap();
        Arrays.stream(terms).forEach(term -> {
            String[] splitTerm = term.split(" ");
            termMap.put(splitTerm[0], Integer.parseInt(splitTerm[1]));
        });
        String[] parsedToday = today.split("\\.");
        int todayYear = Integer.parseInt(parsedToday[0]);
        int todayMonth = Integer.parseInt(parsedToday[1]);
        int todayDay = Integer.parseInt(parsedToday[2]);
        LocalDate todayDate = LocalDate.of(todayYear, todayMonth, todayDay);
        for(int i = 0; i < privacies.length; i ++) {
            String[] date = privacies[i].split(" ")[0].split("\\.");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            int termMonth = termMap.get(privacies[i].split(" ")[1]);
            LocalDate curDate = LocalDate.of(year, month, day).plusMonths(termMonth);

            if(todayDate.isAfter(curDate) || todayDate.isEqual(curDate)) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
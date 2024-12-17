import java.util.*;
class Solution {
    List<String> route = new ArrayList();
    Map<String, PriorityQueue<String>> graph = new HashMap();
    public String[] solution(String[][] tickets) {
        Arrays.stream(tickets).forEach(ticket -> graph.computeIfAbsent(ticket[0], key -> new PriorityQueue<>()).offer(ticket[1]));
        dfs("ICN");
        Collections.reverse(route);
        return route.toArray(new String[0]);
    }
    public void dfs(String start) {
        while(graph.containsKey(start) && !graph.get(start).isEmpty()) {
            dfs(graph.get(start).poll());
        }
        route.add(start);
    }
}
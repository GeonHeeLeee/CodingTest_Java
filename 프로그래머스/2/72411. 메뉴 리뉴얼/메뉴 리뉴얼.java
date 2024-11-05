import java.util.*;
class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList();
        Map<String, Integer> orderMap = new HashMap();
        Map<Integer, Integer> maxMap = new HashMap();
        for(int courseNum : course) {
            for(String order : orders) {
                dfs(order, courseNum, new StringBuilder(), orderMap, new boolean[order.length()], 0);
            }
            int maxCourseNum = Integer.MIN_VALUE;
            for(String key : orderMap.keySet()) {
                if(key.length() == courseNum) {
                    maxCourseNum = Math.max(maxCourseNum, orderMap.get(key));
                }
                maxMap.put(courseNum, maxCourseNum);
            }
        }

        for(int maxKey : maxMap.keySet()) {
            int maxValue = maxMap.get(maxKey);
            if(maxValue != Integer.MIN_VALUE && maxValue > 1) {
                for(String orderKey : orderMap.keySet()) {
                    if(orderMap.get(orderKey) == maxValue && orderKey.length() == maxKey) {
                        answer.add(orderKey);
                    }
                }
            }

        }

        Collections.sort(answer);
        return answer.stream().toArray(String[]::new);
    }
    public void dfs(String order, int count, StringBuilder sb, Map<String, Integer> orderMap, boolean[] visited, int index) {
        if(sb.length() == count) {
            char[] chars = sb.toString().toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            orderMap.put(key, orderMap.getOrDefault(key, 0) + 1);
            return;
        }
        for(int i = index; i < order.length(); i ++) {
            if(!visited[i]) {
                visited[i] = true;
                sb.append(order.charAt(i));
                dfs(order, count, sb, orderMap, visited, i + 1);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
        
    }
}
import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 각각 2글자씩 잘라서 모음
        // 이 때, 특수문자는 제외하는 로직 필요
        str1 = str1.toLowerCase();
        Map<String, Integer> map1 = new HashMap<>();
        for(int s = 0; s < str1.length() - 1; s++) {
            char c1 = str1.charAt(s);
            char c2 = str1.charAt(s + 1);

            // 두 문자 모두 알파벳인지 확인 (특수문자 제외)
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                map1.put("" + c1 + c2, map1.getOrDefault("" + c1 + c2, 0) + 1); // 문자 두 개를 조합하여 저장
            } 
        }
        
        str2 = str2.toLowerCase();
        Map<String, Integer> map2 = new HashMap<>();
        for(int s = 0; s < str2.length() - 1; s++) {
            char c1 = str2.charAt(s);
            char c2 = str2.charAt(s + 1);

            // 두 문자 모두 알파벳인지 확인 (특수문자 제외)
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                map2.put("" + c1 + c2, map2.getOrDefault("" + c1 + c2, 0) + 1); // 문자 두 개를 조합하여 저장
            } 
        }
        
        // 교집합, 합집합 계산
        int same = 0; // 교집합
        for(Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            int map1Count = entry.getValue();
            int map2Count = map2.getOrDefault(key, 0);
            
            same += Math.min(map1Count, map2Count);
        }
        
        int sum = 0; // 합집합
        for(Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            int map1Count = entry.getValue();
            int map2Count = map2.getOrDefault(key, 0);
            
            sum += Math.max(map1Count, map2Count); // 합집합 수
        }
        
        // map2에만 있는 요소 추가
        for(Map.Entry<String, Integer> entry : map2.entrySet()) {
            if(!map1.containsKey(entry.getKey())) {
                sum += entry.getValue();
            }
        }
        
        double jaccard = (sum == 0) ? 1 : (double) same / sum;

        return (int) (jaccard * 65536);
    }
}
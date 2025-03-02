import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 1. 문자열 전처리 (중괄호 제거 및 숫자만 추출)
        s = s.substring(2, s.length() - 2).replace("},{", "-");
        
        // 2. 각 집합을 List<int[]> 형태로 변환
        String[] sets = s.split("-");
        Arrays.sort(sets, Comparator.comparingInt(String::length)); // 길이 순 정렬
        
        // 3. 결과 저장을 위한 Set 및 List
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        
        // 4. 순서대로 숫자 추가
        for (String set : sets) {
            for (String num : set.split(",")) {
                int value = Integer.parseInt(num);
                if (!seen.contains(value)) {
                    seen.add(value);
                    result.add(value);
                }
            }
        }
        
        // 5. 결과 배열로 변환
        return result.stream().mapToInt(i -> i).toArray();
    }
}

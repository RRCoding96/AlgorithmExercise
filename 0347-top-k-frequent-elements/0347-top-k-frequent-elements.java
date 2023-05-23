import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<int[]> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // System.out.println(entry.getKey() + " " + entry.getValue());
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        
        int[] answer = new int[k];
        for(int i = 0; i < k; i++) {
            answer[i] = list.get(i)[0];
        }
        
        return answer;
    }
}
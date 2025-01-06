import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Map<Integer, Integer> map1 = new HashMap<>();
        for(int n : nums1) {
            map1.put(n, map1.getOrDefault(n, 0) + 1);
        }
        
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int n : nums2) {
            map2.put(n, map2.getOrDefault(n, 0) + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            int key = entry.getKey();
            int count1 = entry.getValue();
            
            Integer count2 = map2.get(key);
                        
            if(count2 != null) {
                int loopCount = Math.min(count1, count2);
                for(int i = 0; i < loopCount; i++) {
                    result.add(key);
                }
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        
        List<Integer> list = Arrays.stream(nums)
            .distinct()
            .boxed()
            .toList();
        
        for(int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        
        return list.size();
    }
}
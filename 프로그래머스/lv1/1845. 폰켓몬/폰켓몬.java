import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int targetSize = (int)(nums.length / 2);
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        
        int setSize = set.size();
        
        if(setSize >= targetSize) {
            answer = targetSize;
        } else {
            answer = setSize;
        }
        
        return answer;
    }
}
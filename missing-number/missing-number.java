import java.util.*;

class Solution {
    public int missingNumber(int[] nums) {
        int size = nums.length;
        
        Set<Integer> set = new TreeSet<>();
        for(int n : nums) {
            set.add(n);
        }
        
        int count = 0;
        int before = -1;
        for(int n : set) {
            // System.out.println(n);
            int diff = n - before;
            if(diff != 1) {
                return n - 1;
            }
            before = n;
            count++;
        }
        
        if(count != size + 1) {
            return size;
        }
        
        return -1;
    }
}
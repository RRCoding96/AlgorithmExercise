import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> check = new HashSet<>();
        Set<Integer> find = new HashSet<>();
        
        for(int n : nums) {
            if(check.contains(n)) {
                find.remove(n);
            } else {
                check.add(n);
                find.add(n);
            }
        }
        
        for(int n : find) {
            return n;
        }
        
        return -1;
    }
}
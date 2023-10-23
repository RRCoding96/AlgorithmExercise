import java.util.*;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int n : candies) {
            max = Math.max(max, n);
        }
        
        List<Boolean> result = new ArrayList<>();
        
        for(int n : candies) {
            if(n + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        
        return result;
        
    }
}
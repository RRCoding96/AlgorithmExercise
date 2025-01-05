import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        
        int maxValue = prices[prices.length - 1];
        int minValue = maxValue;
        
        int result = 0;
        for(int i = prices.length - 1; i >= 0; i--) {
            int nowValue = prices[i];
            
            if(nowValue < maxValue) {
                result += maxValue - nowValue;
            }
            maxValue = nowValue;
            
        }
        
        return result;
    }
}
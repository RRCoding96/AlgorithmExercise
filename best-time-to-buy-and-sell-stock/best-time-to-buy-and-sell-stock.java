class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        
        int answer = 0;
        for(int price : prices) {
            minPrice = Math.min(minPrice, price);
            answer = Math.max(answer, price - minPrice);
        }
        
        return answer;
    }
}
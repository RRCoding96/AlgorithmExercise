class Solution {
    public boolean isHappy(int n) {
        
        if(n == 1) return true;
        
        Set<Integer> set = new HashSet<>();
        
        while(n > 1) {
            String token = String.valueOf(n);
            int sum = 0;
            for(char c : token.toCharArray()) {
                sum += (c - '0') * (c - '0');
            }
            
            if(set.contains(sum)) {
                return false;
            }
            
            if(sum == 1) {
                return true;
            } else {
                n = sum;
            }
            
            set.add(sum);
        }
        
        return false;
    }
}
class Solution {
    public int[] solution(int n, int m) {
        
        int min = n < m ? n : m;
        int max = n > m ? n : m;
        
        int gcd = findGcd(min, max);
        // System.out.println(gcd);
        int lcm = findLcm(min, max, gcd);
        
        int[] answer = new int[]{gcd, lcm};
        return answer;
    }
    
    public int findGcd(int min, int max) {
        while(min != 0) {
            int r = max % min;
            max = min;
            min = r;
        }
        return max;
    }
    
    public int findLcm(int min, int max, int gcd) {
        return (min * max) / gcd;
    }
}
class Solution {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        
        int s = Integer.MAX_VALUE;
        int e = 0;
        
        for(int i = 0; i < stones.length; i++) {
            s = Math.min(s, stones[i]);
            e = Math.max(e, stones[i]);
        }
        
        while(s <= e) {
            int mid = (s + e) / 2;
            
            if(check(stones, mid, k)) {
                s = mid + 1;
            } else {
                e = mid - 1;
                answer = Math.min(answer, mid);
            }
        }
        
        return answer;
    }
    
    public boolean check(int stones[], int mid, int k) {
        int cnt = 0;
        for(int v : stones) {
            if(v <= mid) {
                cnt++;
            } else {
                cnt = 0;
            }
            
            if(cnt == k) {
                return false;
            }
        }
        
        return true;
    }
}
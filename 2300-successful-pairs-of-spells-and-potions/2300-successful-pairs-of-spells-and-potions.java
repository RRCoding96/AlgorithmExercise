import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int p = potions.length, temp;
        int[] ans = new int[n];
        
        Arrays.sort(potions);
        
        for(int i = 0; i < n; i++){
            temp = binarySearch(spells[i], potions, success);
            ans[i] = (temp == p)? 0 : p - temp;
        }
        
        return ans;
    }
    
    int binarySearch(int t, int[] p, long success) {
        int l = 0;
        int r = p.length-1;
        int mid;
        
        while(l <= r){
            mid = (l + r) / 2;
            
            if((long)t * p[mid] < success )
                l = mid + 1;
            else
                r = mid - 1;
        }
        
        return l;
    }
}
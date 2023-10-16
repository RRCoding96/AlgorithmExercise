import java.util.*;

class Solution {
    int len;
    List<Integer> arr;
    boolean[] check;
    List<List<Integer>> result;
    
    public List<List<Integer>> permute(int[] nums) {
        len = nums.length;
        arr = new ArrayList<>();
        check = new boolean[len];
        result = new ArrayList<>();
        
        bt(0, nums);
        
        return result;
    }
    
    void bt(int depth, int[] nums) {
        if(depth == len) {
            List<Integer> temp = new ArrayList<>();
            for(int n : arr) {
                temp.add(n);
            }
            result.add(temp);
            return;
        }
        
        for(int i = 0; i < len; i++) {
            int value = nums[i];
            
            if(check[i]) continue;
            
            check[i] = true;
            arr.add(value);
            
            bt(depth + 1, nums);
            
            arr.remove(arr.size() - 1);
            check[i] = false;
        }
    }
}
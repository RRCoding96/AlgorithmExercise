import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Set<Integer> leftSet = new HashSet<>();
        Set<Integer> rightSet = new HashSet<>();
        
        int[] left = new int[topping.length];
        int[] right = new int[topping.length];
        for(int i = 0; i < topping.length; i++) {
            leftSet.add(topping[i]);
            left[i] = leftSet.size();
            
            rightSet.add(topping[topping.length - 1 - i]);
            right[topping.length - 1 - i] = rightSet.size();
        }
        
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        
        for(int i = 0; i < topping.length - 1; i++) {
            if(left[i] == right[i + 1]) {
                answer++;
            }
        }
        
        
        return answer;
    }
}
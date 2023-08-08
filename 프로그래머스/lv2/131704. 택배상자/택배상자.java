import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int n = order.length;
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        int orderIdx = 0;
        for(int hand = 1; hand <= n; hand++) {
            int top = stack.peek();
            int oNum = order[orderIdx];
            
            if(hand == oNum) {
                answer++;
                orderIdx++;
                continue;
            }
            
            if(top == oNum) {
                answer++;
                stack.pop();
                orderIdx++;
                hand--;
                continue;
            }
            
            stack.push(hand);
        }
        
        while(!stack.isEmpty()) {
            if(orderIdx >= n) break;
            
            int top = stack.pop();
            if(top == order[orderIdx]) {
                answer++;
                orderIdx++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}
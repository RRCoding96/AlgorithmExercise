import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        // 중간 처리
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        // 나머지 처리(가격 한번도 안떨어짐)
        while (!stack.isEmpty()) { 
            answer[stack.peek()] = prices.length - 1 - stack.peek();
            stack.pop();
        }

        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Data> stack = new Stack<>();
        
        stack.add(new Data(0, numbers[0]));
        
        for(int i = 1; i < numbers.length; i++) {
            int now = numbers[i];
            
            while(true) {
                if(stack.size() <= 0) break;
                
                Data top = stack.peek();
                
                if(top.value >= now) break;
                
                int topIndex = top.index;
                int topValue = top.value;
                
                answer[topIndex] = now;
                
                stack.pop();
            }
            

            
            stack.add(new Data(i, now));
        }
        
        for(int i = 0; i < answer.length; i++) {
            if(answer[i] == 0) {
                answer[i] = -1;
            }
        }
        
        return answer;
    }
    
    static class Data {
        int index;
        int value;
        
        public Data(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
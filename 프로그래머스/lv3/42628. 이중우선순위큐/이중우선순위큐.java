import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String op : operations) {
            String[] order = op.split(" ");
            
            String command = order[0];
            int num = Integer.parseInt(order[1]);
            
            if(command.equals("I")) {
                minPq.add(num);
                maxPq.add(num);
                continue;
            }
            
            if(command.equals("D")) {

                if(num == 1) {
                    if(maxPq.size() <= 0) {
                        continue;
                    }
                    
                    int value = maxPq.poll();
                    minPq.remove(value);
                    continue;
                } else if(num == -1) {
                    if(minPq.size() <= 0) {
                        continue;
                    }
                    int value = minPq.poll();
                    maxPq.remove(value);
                    continue;
                }
            }
            
        }
        
        if(minPq.size() > 0) {
            int maxValue = maxPq.poll();
            int minValue = minPq.poll();
            
            answer[0] = maxValue;
            answer[1] = minValue;
        } 
        
        
        return answer;
    }
}
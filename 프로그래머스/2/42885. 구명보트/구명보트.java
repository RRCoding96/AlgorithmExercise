import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length - 1;
        while(start <= end) {
            int light = people[start];
            int heavy = people[end];
            
            int sum = 0;
            if(start == end) {
                sum = light;
            } else {
                sum = light + heavy;
            }
            
            if(sum <= limit) {
                answer++;
                start++;
                end--;
            } else {
                answer++;
                end--;
            }
        }
        
        return answer;
    }
}
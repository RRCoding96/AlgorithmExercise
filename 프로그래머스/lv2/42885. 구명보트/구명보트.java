import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int s = 0;
        int e = people.length - 1;
        while(s <= e) {
            int total = 0;
            if(s == e) {
                total = people[s];
            } else {
                total = people[s] + people[e];
            }
            
            if(total > limit) {
                answer++;
                e--;
            } else {
                answer++;
                s++;
                e--;
            }
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize <= 0) {
            answer += 5 * cities.length;
            return answer;
        }
        
        LinkedList<String> window = new LinkedList<>();
        for(String city : cities) {
            city = city.toUpperCase();
            if(window.contains(city)) {
                answer++;
                window.remove(city);
                window.add(city);
            } else {
                if(window.size() == cacheSize) {
                    answer += 5;
                    window.removeFirst();
                    window.add(city); 
                } else if(window.size() < cacheSize) {
                    answer += 5;
                    window.add(city);
                }
                
            }
            
            // for(int i = 0; i < window.size(); i++) {
            //     System.out.print(window.get(i) + " ");
            // }
            // System.out.println(answer);
            // System.out.println();
        }
        
        return answer;
    }

}
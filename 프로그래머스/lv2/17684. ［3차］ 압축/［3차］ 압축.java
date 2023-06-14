import java.util.*;

class Solution {
    
    Map<String, Integer> map;
    
    public int[] solution(String msg) {
        
        ArrayList<Integer> result = new ArrayList<>();
        
        init();
        int idx = 27;
        
        int s = 0;
        while(true) {
            if (s >= msg.length()) {
                break;
            }
            
            for(int e = msg.length() - 1; e >= s; e--) {
                String now = msg.substring(s, e + 1); // 범위 조심
                if(!map.containsKey(now)) {
                    continue;
                } else {
                    result.add(map.get(now));
                    
                    String temp = "";
                    if(e + 2 <= msg.length()) {
                        temp = msg.substring(s, e + 2);
                    } else {
                        temp = msg.substring(s, e + 1);
                    }
                    
                    // System.out.println(temp);
                    map.put(temp, idx);
                    idx++;
                    s = e + 1;
                    break;
                }
            }
            
            
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    public void init() {
        map = new HashMap<>();
        
        for(int i = 65; i <= 90; i++) {
            map.put(String.valueOf((char)i), i - 64);
            // System.out.println(String.valueOf((char)i) + " " + (i - 64));
        }
    }
}
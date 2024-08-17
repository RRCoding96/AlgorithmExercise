import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantIdx = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            wantIdx.put(want[i], i);
        }
        
        int[] check = new int[want.length];
        for(int i = 0; i < 10; i++) {
            String menu = discount[i];
            
            if(wantIdx.containsKey(menu)) {
                int idx = wantIdx.get(menu);
                check[idx]++;
            }
        }
        
        // System.out.println(Arrays.toString(check));
        
        if(checkCnt(number, check)) {
            answer++;
        }
        
        int s = 1;
        int e = s + 9;
        while(e < discount.length - 1) {
            e = s + 9;
            String sMenu = discount[s - 1];
            String eMenu = discount[e];
            
            if(wantIdx.containsKey(sMenu)) {
                int sIdx = wantIdx.get(sMenu);
                check[sIdx]--;
            }
            
            if(wantIdx.containsKey(eMenu)) {
                int eIdx = wantIdx.get(eMenu);
                check[eIdx]++;
            }
                        
            if(checkCnt(number, check)) {
                answer++;
            }
            
            s++;
        }


        return answer;
    }
    
    public boolean checkCnt(int[] target, int[] now) {
        for(int i = 0; i < target.length; i++) {
            if(target[i] > now[i]) {
                return false;
            }
        }
        
        return true;
    }
}
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        
        Map<Integer, Integer> fruitCntMap = new HashMap<>();
        for(int size : tangerine) {
            fruitCntMap.put(size, fruitCntMap.getOrDefault(size, 0) + 1);
        }
        
        // System.out.println(fruitCntMap.toString());
        
        for(Map.Entry<Integer, Integer> entry : fruitCntMap.entrySet()) {
            int size = entry.getKey();
            int cnt = entry.getValue();
            pq.add(new int[]{size, cnt});
        }
        
        while(!pq.isEmpty()) {
            int[] rst = pq.poll();
            int size = rst[0];
            int cnt = rst[1];
            
            // System.out.println(size + ": " + cnt);
            
            k -= cnt;

            answer++; 
            
            if(k <= 0) break;  
        }
        
        
        

        
        return answer;
    }

}
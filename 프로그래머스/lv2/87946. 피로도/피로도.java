import java.util.*;

class Solution {
    
    int answer;
    int len;
    static boolean[] isVisited;
    int[][] dungeons;
    
    public int solution(int k, int[][] dungeons) {
        this.answer = 0;
        this.len = dungeons.length;
        isVisited = new boolean[len];
        this.dungeons = dungeons;
        
        bt(0, k);
        
        return answer;
    }
    
    public void bt(int depth, int nowEnergy) {
        
        // if(depth == len) {
        //     int cnt = 0;
        //     for(int i = 0; i < len; i++) {
        //         if(isVisited[i]) {
        //             cnt++;
        //         }
        //     }
        //     answer = Math.max(answer, cnt);
        //     return;
        // }
        
        for(int i = 0; i < len; i++) {
            
            if(isVisited[i]) continue;
            
            int need = dungeons[i][0];
            int cost = dungeons[i][1];
            
            if(nowEnergy < need) continue;
            
            isVisited[i] = true;
            bt(depth + 1, nowEnergy - cost);
            isVisited[i] = false;
        }
        
        answer = Math.max(answer, depth);
        
    }
}
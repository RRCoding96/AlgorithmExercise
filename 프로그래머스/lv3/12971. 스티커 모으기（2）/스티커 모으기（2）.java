import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        if(sticker.length == 1) {
            return sticker[0];
        }
        
        if(sticker.length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }
        
        if(sticker.length == 3) {
            return Math.max(sticker[0], 
                           Math.max(sticker[1], sticker[2]));
        }

        int[] dpA = new int[sticker.length];
        int[] dpB = new int[sticker.length];
        int[] dpC = new int[sticker.length];
        
        // 0번째 스티커 뜯는거부터 시작
        dpA[0] = sticker[0];
        dpA[1] = dpA[0];
        for(int i = 2; i < sticker.length - 1; i++) {
            dpA[i] = Math.max(dpA[i - 2] + sticker[i], dpA[i - 1]);
        }
        // 1번째 스티커 뜯는거부터 시작
        dpB[1] = sticker[1];
        dpB[2] = dpB[1];
        for(int i = 3; i < sticker.length; i++) {
            dpB[i] = Math.max(dpB[i - 2] + sticker[i], dpB[i - 1]);
        }
        
        // 2번째 스티커 뜯는거부터 시작
        dpC[2] = sticker[2];
        dpC[3] = dpC[2];
        for(int i = 4; i < sticker.length; i++) {
            dpC[i] = Math.max(dpC[i - 2] + sticker[i], dpC[i - 1]);
        }
        
        answer = Math.max(dpA[sticker.length - 2], 
                         Math.max(dpB[sticker.length - 1], dpC[sticker.length - 1]));

        return answer;
    }
}
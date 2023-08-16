import java.util.*;

class Solution {
    
    int[] totalWeak;
    int[] friend;
    boolean[] check;
    
    int answer;
    
    public int solution(int n, int[] weak, int[] dist) {
        answer = Integer.MAX_VALUE;
        
        // 전체 파손 부위 생성
        totalWeak = new int[weak.length * 2 - 1];
        for(int i = 0; i < weak.length; i++) {
            totalWeak[i] = weak[i];
        }
        for(int i = weak.length; i < totalWeak.length; i++) {
            totalWeak[i] = weak[i - weak.length] + n;
        }
        
        friend = new int[dist.length];
        check = new boolean[dist.length];
        for(int s = 0; s < weak.length; s++) {
            int e = s + weak.length - 1;
            int[] nowWeak = new int[weak.length];
            int idx = 0;
            for(int i = s; i <= e; i++) {
                nowWeak[idx++] = totalWeak[i];
            }
                        
            makeFriendComb(0, friend.length, dist, nowWeak);
        }
        
        if(answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        
        return answer;
    }
    
    void makeFriendComb(int depth, int len, int[] dist, int[] nowWeak) {
        if(depth == len) {
            int result = checkAnswer(friend, nowWeak);
            answer = Math.min(answer, result);
            
            // System.out.println(Arrays.toString(friend));
            // System.out.println(Arrays.toString(nowWeak));
            // System.out.println(result);
            // System.out.println();
            return;
        }
        
        for(int i = 0; i < len; i++) {
            if(check[i]) continue;
            
            check[i] = true;
            friend[depth] = dist[i];
            
            makeFriendComb(depth + 1, len, dist, nowWeak);
            
            check[i] = false;
            friend[depth] = 0;
            
        }
    }
    
    int checkAnswer(int[] friend, int[] nowWeak) {
        int weakIdx = 0;
        int friendIdx = 0;
        while(true) {
            if(weakIdx >= nowWeak.length) {
                break;
            }
            
            if(friendIdx >= friend.length) {
                break;
            }
            
            int limit = nowWeak[weakIdx] + friend[friendIdx];
            
            while(true) {
                if(weakIdx >= nowWeak.length) {
                    break;
                }
                
                if(limit < nowWeak[weakIdx]) {
                    break;
                }
                
                weakIdx++;
            }
            
            friendIdx++;
        }
        
        if(weakIdx < nowWeak.length) {
            return Integer.MAX_VALUE;
        } else {
            return friendIdx;
        }
    }
}
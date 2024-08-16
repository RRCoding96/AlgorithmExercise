import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> nameToRank = new HashMap<>();
        Map<Integer, String> rankToName = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            String name = players[i];
            nameToRank.put(name, i);
            rankToName.put(i, name);
        }
        
        for(String call : callings) {
            // 불린 사람 등수
            int calledNowRank = nameToRank.get(call);
            
            // 앞 사람 등수
            int frontRank = calledNowRank - 1;
            // 앞 사람 이름
            String frontName = rankToName.get(frontRank);
            
            // 불린사람, 앞 사람 자리 바꿈
            nameToRank.put(call, frontRank);
            nameToRank.put(frontName, calledNowRank);
            
            rankToName.put(frontRank, call);
            rankToName.put(calledNowRank, frontName);
        }
        
        String[] answer = new String[players.length];
        for(int i = 0; i < players.length; i++) {
            answer[i] = rankToName.get(i);
        }
        
        
        return answer;
    }
    
}
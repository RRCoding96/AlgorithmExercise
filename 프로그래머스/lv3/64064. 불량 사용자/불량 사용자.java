import java.util.*;

class Solution {
    
    static int answer;
    static boolean[] userCheck;
    static int bannedLen;
    static List<String>[] mapping;
    static List<String> userIds;
    
    static Set<List<Integer>> set;
    
    public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        bannedLen = banned_id.length;
        userIds = Arrays.asList(user_id);
        
        mapping = new ArrayList[bannedLen];
        for(int i = 0; i < bannedLen; i++) {
            mapping[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < bannedLen; i++) {
            for(int j = 0; j < user_id.length; j++) {
                if(isMatch(user_id[j], banned_id[i])) {
                    mapping[i].add(user_id[j]);
                }
            }
        }
        
        // for(int i = 0; i < bannedLen; i++) {
        //     for(int j = 0; j < mapping[i].size(); j++) {
        //         System.out.print(mapping[i].get(j) + " ");
        //     }
        //     System.out.println();
        // }
        
        
        
        set = new HashSet<>();
        userCheck = new boolean[user_id.length];
        bt(0);
        

        
        // return answer;
        return set.size();
    }
    
    public void bt(int bannedIdx) {
        
        if(bannedIdx == bannedLen) {
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < userCheck.length; i++) {
                if(userCheck[i]) {
                    list.add(i);
                }
            }
            set.add(list);
            
            // answer++;

            return;
        }
        
        for(int i = 0; i < mapping[bannedIdx].size(); i++) {
            String name = mapping[bannedIdx].get(i);
            int nameIdx = userIds.indexOf(name);
            
            if(!userCheck[nameIdx]) {
                userCheck[nameIdx] = true;
                
                bt(bannedIdx + 1);
                
                userCheck[nameIdx] = false;
            }
        }
    }
    
    public boolean isMatch(String name, String target) {
        if(name.length() != target.length()) {
            return false;
        }
        for(int i = 0; i < name.length(); i++) {
            if(target.charAt(i) == '*') continue;
            
            if(name.charAt(i) != target.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}
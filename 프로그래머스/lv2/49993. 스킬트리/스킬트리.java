import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;;
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < skill.length(); i++) {
            map.put(skill.charAt(i), i);
        }
        
        for(String tree : skill_trees) {
            int top = -1;
            // System.out.println(tree);
            for(int i = 0; i < tree.length(); i++) {
                char c = tree.charAt(i);
                if(map.containsKey(c)) {
                    int idx = map.get(c);
                    if(idx == top + 1) {
                        top = idx;
                        // System.out.println(c);
                    } else {
                        // System.out.println("안됨");
                        answer--;
                        break;
                    }
                } 
            }
            
            
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    
    int maxLen;
    Map<Integer, List<Character>> map;
    List<String> answer;
    List<Character> temp;
    Set<Character> check;
    
    public List<String> letterCombinations(String digits) {
        maxLen = digits.length();
        
        if(maxLen == 0) {
            return new ArrayList<>();
        }
        
        map = new HashMap<>();
        answer = new ArrayList<>();
        temp = new ArrayList<>();
        check = new HashSet<>();
        // System.out.println((char)97);
        
        int j = 97;
        for(int i = 2; i <= 9; i++) {
            map.put(i, new ArrayList<>());
            int t = 3;
            if(i == 7 || i == 9) t = 4;
            for(int h = 0; h < t; h++) {
                map.get(i).add((char)j++);
            }
        }
        
        // for(Map.Entry<Integer, List<Character>> temp : map.entrySet()) {
        //     List<Character> list = temp.getValue();
        //     for(char c : list) {
        //         System.out.print(c + " ");
        //     }
        //     System.out.println();
        // }
        
        bt(0, digits);
        
        return answer;
    }
    
    void bt(int depth, String digits) {
        if(depth == maxLen) {
            String result = "";
            for(char c : temp) {
                result += c;
            }
            
            answer.add(result);
            return;
        }
        
        List<Character> list = map.get(digits.charAt(depth) - '0');
        
        for(char c : list) {
            // System.out.println(c);
            // if(check.contains(c)) continue;
            
            // check.add(c);
            temp.add(c);
            
            bt(depth + 1, digits);
            
            // check.remove(c);
            temp.remove(temp.size() - 1);
        }
    }
}
class Solution {
    public String solution(String s) {
        String answer = "";
        
        int strLen = s.length();
        if(strLen % 2 == 1) {
            int idx = strLen / 2;
            answer = Character.toString(s.charAt(idx));
        } else {
            int idx1 = strLen / 2 - 1;
            int idx2 = strLen / 2;
            answer +=  Character.toString(s.charAt(idx1));
            answer +=  Character.toString(s.charAt(idx2));
        }
        
        return answer;
    }
}
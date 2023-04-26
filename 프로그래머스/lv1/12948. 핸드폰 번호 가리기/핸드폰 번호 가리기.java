class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        int len = phone_number.length();
        int targetLen = len - 4;
        for(int i = 0; i < targetLen; i++) {
            answer += "*";
        }
        for(int i = targetLen; i < targetLen + 4; i++) {
            answer += String.valueOf(phone_number.charAt(i));
        }
        
        return answer;
    }
}
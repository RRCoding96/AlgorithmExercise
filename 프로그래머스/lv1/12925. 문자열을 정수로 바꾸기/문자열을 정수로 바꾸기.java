class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char check = s.charAt(0);
        if(check == '-') {
            String ns = s.substring(1, s.length());
            answer = -(Integer.parseInt(ns));
        } else if(check == '+'){
            String ns = s.substring(1, s.length());
            answer = Integer.parseInt(ns);
        } else {
            answer = Integer.parseInt(s);
        }
        
        return answer;
    }
}
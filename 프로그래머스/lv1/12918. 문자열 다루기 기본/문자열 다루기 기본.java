class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        
        int cnt = 0;
        
        try{
            int num = Integer.parseInt(s);
            cnt = s.length();
        } catch(Exception e) {
            return false;
        }
        

        if(cnt == 4 || cnt == 6) {
            answer = true;
        }
        
        return answer;
    }
}
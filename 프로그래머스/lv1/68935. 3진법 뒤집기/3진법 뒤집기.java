class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String temp = Integer.toString(n, 3);
        String third = "";
        for(int i = temp.length() - 1; i >= 0; i--) {
            third += Character.toString(temp.charAt(i));
        }
        
        answer = Integer.parseInt(third, 3);
        
        return answer;
    }
}
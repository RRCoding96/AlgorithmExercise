class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int len = p.length();
        for(int i = 0; i < t.length(); i++) {
            int e = i + len - 1;
            if(e >= t.length()) break;
            
            String temp = t.substring(i, e + 1);
            
            // System.out.println(temp);
            
            if(check(temp, p)) {
                // System.out.println(temp);
                answer++;
            }
            
        }
        
        return answer;
    }
    
    public boolean check(String temp, String p) {
        long ta = Long.parseLong(temp);
        long pa = Long.parseLong(p);
        
        if(ta <= pa) {
            return true;
        }
        return false;
    }
}
class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        int day = 0;
        // 7월 이하
        if(a <= 7) {
            day += countUntil7(a, b);
        } 
        // 8월 ~
        else {
            day += 213;
                
            int nMonth = a - 7;
            int mok = (int)(nMonth / 2);
            day += mok * 31 + (nMonth - 1 - mok) * 30 + b;
        }
        
        int nam = day % 7;
        System.out.println(nam);
        
        if(nam == 1) {
            answer = "FRI";
        } else if(nam == 2){
            answer = "SAT";
        } else if(nam == 3){
            answer = "SUN";
        } else if(nam == 4){
            answer = "MON";
        } else if(nam == 5){
            answer = "TUE";
        } else if(nam == 6){
            answer = "WED";
        } else {
            answer = "THU";
        }
        
        return answer;
    }
    
    static int countUntil7(int m, int d) {
        int day = 0;
        
        // 1월
        if(m < 2) {
            day += d;
        } 
        // 2월
        else if(m == 2) {
            day += 31 + d;
        } 
        // 3월 ~ 7월
        else {
            int mok = (int)(m / 2);
            day += (31 * mok) + 29 + (30 * (m - 1 - mok - 1)) + d;

        }
        
        return day;
    }
}
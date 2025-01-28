class Solution {
    public String longestPalindrome(String s) {
        String lps = "";
        
        // 문자열의 모든 문자 탐색
        for(int i = 0; i < s.length(); i++) {
            // 각 문자부터 양쪽으로 늘려가며 palindrome 체크
            
            // 홀수인 경우 
            String oddMax = isPalindrome(s, i, i);
            lps = (lps.length() < oddMax.length()) ? oddMax : lps;
            
            // 짝수인 경우
            String evenMax = isPalindrome(s, i, i + 1);
            lps = (lps.length() < evenMax.length()) ? evenMax : lps;
        }

        return lps;
    }
    
    public String isPalindrome(String s, int left, int right) {
        // 왼쪽 인덱스와 오른쪽 인덱스가 끝에 도달할 때 까지 반복
        while(left >= 0 && right < s.length()) {
            // 양쪽의 글자가 같은 경우 인덱스를 한칸씩 이동
            if(s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } 
            // 양쪽의 글자가 다른 경우 탐색 종료
            else {
                break;
            }
        }
        
        // 인덱스가 이동한 상태로 탐색이 종료되었으므로 이전 인덱스까지 문자열을 잘라서 return
        return s.substring(left + 1, right);
    }
}
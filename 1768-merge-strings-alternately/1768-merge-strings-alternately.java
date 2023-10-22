class Solution {
    public String mergeAlternately(String word1, String word2) {
        int aLen = word1.length();
        int bLen = word2.length();
        
        String answer = "";
        if(aLen == bLen) {
            for(int i = 0; i < aLen; i++) {
                answer += String.valueOf(word1.charAt(i));
                answer += String.valueOf(word2.charAt(i));
            }
        } else if(aLen > bLen) {
            int nextIdx = 0;
            for(int i = 0; i < bLen; i++) {
                answer += String.valueOf(word1.charAt(i));
                answer += String.valueOf(word2.charAt(i));
                nextIdx = i + 1;
            }
            for(int i = nextIdx; i < aLen; i++) {
                answer += String.valueOf(word1.charAt(i));
            }
            
        } else {
            int nextIdx = 0;
            for(int i = 0; i < aLen; i++) {
                answer += String.valueOf(word1.charAt(i));
                answer += String.valueOf(word2.charAt(i));
                nextIdx = i + 1;
            }
            for(int i = nextIdx; i < bLen; i++) {
                answer += String.valueOf(word2.charAt(i));
            }
        }
        
        return answer;
    }
}
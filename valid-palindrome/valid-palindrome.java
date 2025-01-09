class Solution {
    public boolean isPalindrome(String s) {
        String[] tokens = s.split(" ");
        
        String str = "";
        for(String token : tokens) {
            for(int i = 0; i < token.length(); i++) {
                char c = token.charAt(i);
                if(Character.isAlphabetic(c)) {
                    str += Character.toLowerCase(c);
                } else if(Character.isDigit(c)) {
                    str += c;
                }
            }
        }
                
        for(int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        
        return true;
    }
}
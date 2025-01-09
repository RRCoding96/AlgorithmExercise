class Solution {
    public void reverseString(char[] s) {
        
        for(int i = 0; i < s.length / 2; i++) {
            char a = s[i];
            char b = s[s.length - 1 - i];
            
            s[s.length - 1 - i] = a;
            s[i] = b;
        }
    }
}
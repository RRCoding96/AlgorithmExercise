class Solution {
    // 3322251
    // -> 23 32 15 11
    public String countAndSay(int n) {
        
        if (n == 1) return "1";

        StringBuilder sb = new StringBuilder();
        
        String s = countAndSay(n - 1);
        
        char value = s.charAt(0);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if (value == c) {
                count++;
                continue;
            }

            sb.append(Integer.toString(count))
                .append(value);
            
            value = c;
            count = 1;
        }

        sb.append(Integer.toString(count))
            .append(value);

        return sb.toString();
        
    }
}
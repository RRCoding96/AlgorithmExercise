class Solution {
    
    static String[] phone = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    static List<String> ans;
    
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if (digits.equals("")) {
            return ans;
        }
        
        StringBuilder sb = new StringBuilder();
        dfs(0, digits, sb);
        
        return ans;
    }
    
    public void dfs(int depth, String digits, StringBuilder sb) {
        if (depth == digits.length()){
            ans.add(sb.toString());
            return;
        }
        
        int pos = digits.charAt(depth) - '2';
        String text = phone[pos];
        int n = text.length();
        
        for (int i = 0; i < n; i++){
            sb.append(text.charAt(i));
            dfs(depth + 1, digits, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}
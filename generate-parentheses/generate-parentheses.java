class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        
        recursive(res, "(", n - 1, n);
        
        return res;
    }
    
    /**
        open 변수는 열 수 있는 괄호의 갯수, close 변수는 닫을 수 있는 괄호의 갯수
        균형 잡힌 괄호를 만들어야 하기 때문에 close 변수는 open 변수보다 클 때만 붙일 수 있음
    */
    private void recursive(List<String> res, String s, int open, int close) {
        if (open == 0 && close == 0) {
            res.add(s);
            return;
        }

        if (open > 0) {
            recursive(res, s + "(", open - 1, close);
        }

        if (close > open) {
            recursive(res, s + ")", open, close - 1);
        }
    }
}
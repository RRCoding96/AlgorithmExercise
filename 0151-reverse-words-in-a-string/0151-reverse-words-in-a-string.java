class Solution {
    public String reverseWords(String s) {
        String[] list = s.strip().split(" ");
        
        // for(String str : list) {
        //     System.out.println(str);
        // }
        
        String answer = "";
        for(int i = list.length - 1; i >= 0; i--) {
            String str = list[i];
            if(str.isBlank()) continue;
            answer += " ";
            answer += str;
        }
        return answer.substring(1);
    }
}
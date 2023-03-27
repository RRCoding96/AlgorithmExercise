import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int len = name.length();
        
        int index;
        int move = len - 1;
        
        for(int i=0; i<len; i++) {
            // 상하(알파벳 바꾸는 버튼)
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            index = i + 1;
            while(index < len && name.charAt(index) == 'A') {
                index++;
            }
            
            // 순서대로 가는 경우, 뒤로 돌아가는 경우 중 더 짧은 것 찾기
            move = Math.min(move, i*2 + len - index);
            // BBBBAAAAAAAAAAB -> 처음부터 뒷부분을 먼저 입력하는 것이 더 빠른 경우
            move = Math.min(move, (len - index) * 2 + i);
        }
        answer += move;
        return answer;
    }
}
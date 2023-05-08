
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        boolean[] check = new boolean[10];
        
        for(int i = 0; i < numbers.length; i++) {
            int value = numbers[i];
            check[value] = true;
        }
        
        for(int i = 0; i < 10; i++) {
            if(!check[i]) {
                answer += i;
            }
        }
        
        return answer;
    }
}
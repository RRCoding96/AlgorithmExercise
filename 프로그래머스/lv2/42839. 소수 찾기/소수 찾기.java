import java.util.*;

class Solution {
    
    Set<Integer> results;
    String number;
    boolean[] check;
    
    public int solution(String numbers) {
        int answer = 0;
        
        results = new HashSet<>();
        check = new boolean[numbers.length()];
        
        for(int i = 1; i <= numbers.length(); i++) {
            number = "";
            generateNumbers(0, i, numbers);
        }
        
        answer = results.size();
        return answer;
    }
    
    public void generateNumbers(int depth, int len, String numbers) {
        if(depth == len) {
            int num = Integer.parseInt(number);
            
            if(checkPrime(num)) {
                results.add(num);
                // System.out.println(num);
            }
            
            return;
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(check[i]) continue;
            
            String temp = number;
            
            check[i] = true;
            number += numbers.charAt(i);
            
            generateNumbers(depth + 1, len, numbers);
            
            number = temp;
            check[i] = false;
        }
    }
    
    public boolean checkPrime(int number) {
        if(number == 1 || number == 0) {
            return false;
        }
        
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
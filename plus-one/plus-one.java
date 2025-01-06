class Solution {
    public int[] plusOne(int[] digits) {
        
        List<Integer> reverseList = new ArrayList<>();
        
        int upDigit = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            
            int post = digit + upDigit;
            
            if(post == 10) {
                reverseList.add(0);
                upDigit = 1;
            } else {
                reverseList.add(post);
                upDigit = 0;
            }
        }
        
        if(upDigit == 1) {
            reverseList.add(1);
        }
        
        int[] result = new int[reverseList.size()];
        int index = 0;
        for(int i = reverseList.size() - 1; i >= 0; i--) {
            result[index++] = reverseList.get(i);
        }
        
        return result;
    }
}
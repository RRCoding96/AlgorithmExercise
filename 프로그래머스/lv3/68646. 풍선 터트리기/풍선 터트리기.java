class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        // 0 -> 왼, 1 -> 오
        int[][] minCheck = new int[2][a.length];
        
        int leftMin = a[0];
        minCheck[0][0] = a[0];
        for(int i = 1; i < a.length; i++) {
            if(leftMin > a[i]) {
                leftMin = a[i];
            }
            minCheck[0][i] = leftMin;
        }
        
        int rightMin = a[a.length - 1];
        minCheck[1][a.length - 1] = a[a.length - 1];
        for(int i = a.length - 1; i >= 0; i--) {
            if(rightMin > a[i]) {
                rightMin = a[i];
            }
            minCheck[1][i] = rightMin;
        }
        
        for(int i = 0; i < a.length; i++) {
            if(minCheck[0][i] >= a[i] || minCheck[1][i] >= a[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}
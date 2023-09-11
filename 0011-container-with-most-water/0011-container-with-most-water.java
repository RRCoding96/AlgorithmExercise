class Solution {
    public int maxArea(int[] height) {
        int answer = -1;
        
        int s = 0;
        int e = height.length - 1;
        
        while(s < e) {
            int sHeight = height[s];
            int eHeight = height[e];
            int h = Math.min(sHeight, eHeight);
            
            int len = e - s;
            
            int size = h * len;
            answer = Math.max(answer, size);
            if(height[s] > height[e]) {
                e--;
            } else if(height[s] < height[e]) {
                s++;
            } else {
                s++;
            }
        }
        
        // System.out.println(answer);
        
        s = 0;
        e = height.length - 1;
        
        while(s < e) {
            int sHeight = height[s];
            int eHeight = height[e];
            int h = Math.min(sHeight, eHeight);
            
            int len = e - s;
            
            int size = h * len;
            answer = Math.max(answer, size);
            if(height[s] > height[e]) {
                e--;
            } else if(height[s] < height[e]) {
                s++;
            } else {
                e--;
            }
        }
        
        // System.out.println(answer);
        
        return answer;
    }
}
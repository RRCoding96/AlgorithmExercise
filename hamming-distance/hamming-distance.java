class Solution {
    public int hammingDistance(int x, int y) {
        List<Integer> xBit = new ArrayList<>();
        List<Integer> yBit = new ArrayList<>();
        
        while(x > 0) {
            int value = x % 2;
            xBit.add(value);
            x /= 2;
        }
        while(y > 0) {
            int value = y % 2;
            yBit.add(value);
            y /= 2;
        }
        
        int xSize = xBit.size();
        int ySize = yBit.size();
        
        if(xSize > ySize) {
            for(int i = 0; i < xSize - ySize; i++) {
                yBit.add(0);
            }
        } else {
            for(int i = 0; i < ySize - xSize; i++) {
                xBit.add(0);
            }
        }
        
        // System.out.println(xBit);
        // System.out.println(yBit);
        // System.out.println("=================");
        
        int answer = 0;
        for(int i = 0; i < xBit.size(); i++) {
            int xValue = xBit.get(i);
            int yValue = yBit.get(i);
            
            if(xValue != yValue) {
                // System.out.println(xValue + " " + yValue);
                answer++;
            }
        }
        
        return answer;
    }
}
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);
        
        if(numRows == 1) {
            return result;
        }
        
        List<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(1);
        result.add(second);
        
        for(int i = 2; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> before = result.get(i - 1);
            
            list.add(1);
            for(int j = 1; j < i; j++) {
                int value = before.get(j - 1) + before.get(j);
                list.add(value);
            }
            list.add(1);
            
            result.add(list);
        }
        
        return result;
    }
}
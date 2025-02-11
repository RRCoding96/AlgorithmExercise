class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        
        // 1. 정렬 (각 구간의 시작점을 기준으로 오름차순)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // 2. 병합할 리스트 생성
        List<int[]> merged = new ArrayList<>();
        
        // 3. 첫 번째 구간 추가
        int[] current = intervals[0];
        merged.add(current);
        
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            
            // 현재 구간의 끝과 다음 구간의 시작을 비교
            if (current[1] >= next[0]) {
                // 겹치는 경우 -> 끝 값을 갱신 (더 큰 값으로 확장)
                current[1] = Math.max(current[1], next[1]);
            } else {
                // 겹치지 않는 경우 -> 새로운 구간 추가
                current = next;
                merged.add(current);
            }
        }
        
        // 4. 리스트를 배열로 변환하여 반환
        return merged.toArray(new int[merged.size()][]);
    }
}
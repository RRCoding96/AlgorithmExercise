import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            answer[i] = findNext(numbers[i]);
        }

        return answer;
    }

    private long findNext(long x) {
        // 짝수면 마지막 비트가 0이므로, x + 1이 정답
        if ((x & 1) == 0) {
            return x + 1;
        }

        // 홀수라면, 가장 낮은 0을 1로 변경 후, 오른쪽 1을 0으로 변경
        long bit = (x & -x);   // 가장 낮은 1 찾기
        long nextX = x + bit;  // 가장 낮은 0을 1로 변경
        long fixBit = (nextX ^ x) >> 2;  // 오른쪽 1을 0으로 변경
        return nextX | fixBit;
    }
}

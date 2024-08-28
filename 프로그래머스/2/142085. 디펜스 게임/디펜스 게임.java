import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int soldier = n;
        int card = k;
        for (int i = 0; i < enemy.length; i++) {
            soldier -= enemy[i];
            pq.add(enemy[i]);

            if (soldier < 0) {
                if (card > 0 && !pq.isEmpty()) {
                    soldier += pq.poll();
                    card--;
                } else {
                    answer = i;
                    break;
                }
            }
        }

        return answer;
    }
}
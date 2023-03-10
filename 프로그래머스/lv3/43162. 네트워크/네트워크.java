import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
         int answer = 0;

        boolean[] isVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                answer++;
                Queue<Integer> que = new LinkedList<>();

                que.add(i);
                isVisited[i] = true;

                while (!que.isEmpty()) {
                    int now = que.poll();

                    int[] graph = computers[now];
                    for (int t = 0; t < n; t++) {
                        if (graph[t] == 1 && !isVisited[t]) {
                            isVisited[t] = true;
                            que.add(t);
                        }
                    }
                }
            }
        }

        return answer;
    }
}
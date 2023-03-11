import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int[] info : edge) {
            int s = info[0];
            int e = info[1];

            graph[s].add(e);
            graph[e].add(s);
        }

        Queue<Integer> que = new LinkedList<>();
        int[] dist = new int[n + 1];
        boolean[] checked = new boolean[n + 1];

        que.add(1);
        checked[1] = true;
        int far_dist = 0;

        while (!que.isEmpty()) {
            int now = que.poll();

            if (far_dist < dist[now]) {
                far_dist = dist[now];
            }

            for (int nxt : graph[now]) {
                if (checked[nxt]) continue;

                que.add(nxt);
                checked[nxt] = true;
                dist[nxt] = dist[now] + 1;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (dist[i] == far_dist) {
                answer++;
            }
        }
        
        return answer;
    }
}
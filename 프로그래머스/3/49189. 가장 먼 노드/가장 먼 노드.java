import java.util.*;

class Solution {
    
    List<Integer>[] graph;
    int[] dist;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        dist = new int[n + 1];
        
        graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] v : edge) {
            int a = v[0];
            int b = v[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        Queue<Integer> que = new LinkedList<>();
        boolean[] checked = new boolean[n + 1];
        int farDist = 0;
        
        que.add(1);
        checked[1] = true;
        
        while(!que.isEmpty()) {
            int now = que.poll();
            
            if(farDist < dist[now]) {
                farDist = dist[now];
            }
            
            for(int next : graph[now]) {
                if(checked[next]) continue;
                
                que.add(next);
                checked[next] = true;
                dist[next] = dist[now] + 1;
            }
        }
        
        for(int i = 2; i <= n; i++) {
            if(dist[i] == farDist) {
                answer++;
            }
        }
        
        
        
        return answer;
    }

}
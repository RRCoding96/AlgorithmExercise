import java.util.*;

class Solution {
    
    static List<Integer>[] graph;
    static int[] distance;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        distance = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            distance[i] = -1;
        }
        
        graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] info : roads) {
            int a = info[0];
            int b = info[1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        bfs(destination, n);
        
        // System.out.println(Arrays.toString(distance));
        
        for(int i = 0; i < sources.length; i++) {
            answer[i] = distance[sources[i]];
        }
        
        return answer;
    }
    
    public void bfs(int start, int n) {
        boolean[] check = new boolean[n + 1];
        Queue<Integer> que = new LinkedList<>();
        
        que.add(start);
        distance[start] = 0;
        check[start] = true;
        
        while(!que.isEmpty()) {
            int now = que.poll();
            int nowDist = distance[now];
            
            for(int next : graph[now]) {
                if(check[next]) continue;
                
                que.add(next);
                distance[next] = nowDist + 1;
                check[next] = true;
            }
        }
    }
}
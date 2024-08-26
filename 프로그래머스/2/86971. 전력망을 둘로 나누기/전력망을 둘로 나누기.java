import java.util.*;

class Solution {
    
    private int cnt;
    private List<Integer>[] graph;
    private boolean[] isVisited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int t = 0; t < n - 1; t++) {
            graph = new ArrayList[n + 1];
            for(int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            
            for(int i = 0; i < n - 1; i++) {
                if(i == t) continue;
                
                int[] wire = wires[i];
                
                int a = wire[0];
                int b = wire[1];
                graph[a].add(b);
                graph[b].add(a);
            }
            
            
            isVisited = new boolean[n + 1];
            cnt = 1;
            
            isVisited[1] = true;
            dfs(1);
            
            int a = cnt;
            int b = n - cnt;
            
            answer = Math.min(answer, Math.abs(a - b));
        }
        
        return answer;
    }
    
    void dfs(int start) {
        
        for(int next : graph[start]) {
            if(isVisited[next]) continue;
            
            isVisited[next] = true;
            cnt++;
            
            dfs(next);
        }
    }
    
}
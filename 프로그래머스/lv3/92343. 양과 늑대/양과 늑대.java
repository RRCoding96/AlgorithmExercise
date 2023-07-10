import java.util.*;

class Solution {
    
    List<Integer>[] graph;
    // boolean[] visited;
    int answer;
    
    public int solution(int[] info, int[][] edges) {
        answer = 0;
        
        graph = new ArrayList[info.length];
        for(int i = 0; i < info.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        
        // visited = new boolean[info.length];
        
        List<Integer> list = new ArrayList<>();
		list.add(0);
        bt(0, 0, 0, list, info);
        
        
        return answer;
    }
    
    public void bt(int now, int sheep, int wolf, List<Integer> nextPos, int[] info) {
        // 늑대/양 수, 양의 최대값 최신화
		if (info[now] == 0) {
            sheep++;
        } else {
            wolf++;
        }
 
		if (wolf >= sheep) {
            return;
        }
        
		answer = Math.max(sheep, answer);
   
		// 다음 탐색 위치 갱신
		List<Integer> list = new ArrayList<>();
		list.addAll(nextPos);
        
		// 다음 탐색 목록중 현재 위치제외
		list.remove(Integer.valueOf(now));
		if (graph[now] != null) {
			for (int nxt : graph[now]) {
				list.add(nxt);
			}
		}
        
		// 갈수 있는 모든 Node Dfs
		for (int next : list) {
			bt(next, sheep, wolf, list, info);
		}
        
    }
}
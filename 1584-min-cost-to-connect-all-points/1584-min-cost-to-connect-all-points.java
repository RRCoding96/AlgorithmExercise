import java.util.*;

class Solution {
    
    int N;
    List<Edge> graph;
    int[] parent;
    int answer;
    
    public int minCostConnectPoints(int[][] points) {
        N = points.length;
        graph = new ArrayList<>();
        answer = 0;
       
        for(int i = 0; i < points.length - 1; i++) {
            int[] nowP = points[i];
            for(int j = i + 1; j < points.length; j++) {
                int[] p = points[j];
                Edge edge = new Edge(i, j, Math.abs(nowP[0] - p[0]) + Math.abs(nowP[1] - p[1]));
                graph.add(edge);
            }
            
            
        }
        Collections.sort(graph);
        
        parent = new int[N];
        for(int i = 0; i < N; i++) {
            parent[i] = i;
        }
        
        for(int i = 0; i < graph.size(); i++) {
            Edge edge = graph.get(i);
            
            if(!isSameParent(edge.s, edge.e)) {
                union(edge.s, edge.e);
                answer += edge.dist;
                
                // System.out.println(edge.dist);
            }
        }
        
        return answer;
    }
    
    void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        
        if(a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
    
    int findParent(int n) {
        if(n == parent[n]) {
            return n;
        }
        
        return parent[n] = findParent(parent[n]);
    }
    
    boolean isSameParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        
        if(a == b) {
            return true;
        }
        
        return false;
    }
    
    static class Edge implements Comparable<Edge> {
        int s, e, dist;
        
        public Edge(int s, int e, int dist) {
            this.s = s;
            this.e = e;
            this.dist = dist;
        }
        
        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }
}
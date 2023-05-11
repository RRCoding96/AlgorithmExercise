import java.util.*;

class Solution {
    
    int INF = Integer.MAX_VALUE;
    int n;
    
    List<Node>[] edges;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.n = n;
        
        edges = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for(int[] fare : fares) {
            int front = fare[0];
            int end = fare[1];
            int cost = fare[2];
            
            edges[front].add(new Node(end, cost));
            edges[end].add(new Node(front, cost));
        }
        
        // s -> 전체
        int[] sDistance = dijkstra(s);
        
        // a -> 전체
        int[] aDistance = dijkstra(a);
        // b -> 전체
        int[] bDistance = dijkstra(b);
        
        // System.out.println(Arrays.toString(sDistance));
        // System.out.println(Arrays.toString(aDistance));
        // System.out.println(Arrays.toString(bDistance));
        
        int answer = INF;
        
        for(int i = 1; i <= n; i++) {
            int sToi = sDistance[i];
            int iToa = aDistance[i];
            int iTob = bDistance[i];
            
            answer = Math.min(answer, sToi + iToa + iTob);
        }
        
        return answer;
    }
    
    int[] dijkstra(int start) {
        int[] distance = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            distance[i] = INF;
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });
        
        pq.add(new Node(start, 0));
        distance[start] = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            int nowNumber = now.number;
            int nowCost = now.cost;
            
            // System.out.println(start + " " + nowNumber);
            
            if(distance[nowNumber] < nowCost) continue;
            
            for(Node nxt : edges[nowNumber]) {
                int nxtNumber = nxt.number;
                int nxtCost = nxt.cost;

                int nCost = nowCost + nxtCost;
                if(nCost < distance[nxtNumber]) {
                    distance[nxtNumber] = nCost;
                    pq.add(new Node(nxtNumber, nCost));
                }
            }
            
        }
        return distance;
    }
    
    static class Node {
        int number;
        int cost;
        
        public Node(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }
    }
}
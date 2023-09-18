import java.util.*;

class RecentCounter {
    
    Queue<Integer> que = new LinkedList<>();

    public RecentCounter() {
        
    }
    
    public int ping(int t) {
        que.add(t);

        int s = t - 3000;

        while(que.peek() < s) {
            que.poll();
        }

        return que.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
import java.util.*;

class Solution {
    
    boolean[] keys;
    boolean[] roomCheck;
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        keys = new boolean[rooms.size()];
        roomCheck = new boolean[rooms.size()];
        
        dfs(0, rooms);
        
        boolean answer = true;
        for(int i = 1; i < rooms.size(); i++) {
            boolean check = roomCheck[i];
            if(!check) {
                answer = false;
                break;
            }
        }
        
        return answer;
    }
    
    void dfs(int nextRoomNum, List<List<Integer>> rooms) {
        // if(roomCheck[nextRoomNum]) {
        //     return;
        // }
        
        for(int next : rooms.get(nextRoomNum)) {
            if(roomCheck[next]) continue;
            
            roomCheck[next] = true;
            System.out.println(next + " : " + "true");
            dfs(next, rooms);
        }
    }
    
}
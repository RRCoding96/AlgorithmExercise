import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        char[][] map = new char[maps.length][maps[0].length()];
        for(int i = 0; i < map.length; i++) {
            String line = maps[i];
            for(int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j);
            }
        }
        
        int[] answer = bfs(map);
        return answer;
    }
    
    private int[] bfs(char[][] map) {
        List<Integer> result = new ArrayList<>();
        
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        
        int rowLen = map.length;
        int colLen = map[0].length;
        
        Queue<int[]> que = new LinkedList<>();
        boolean[][] check = new boolean[rowLen][colLen];
        
        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {
                if(map[i][j] == 'X') continue;
                if(check[i][j]) continue;
                
                int cnt = 0;
                que = new LinkedList<>();
                
                que.add(new int[]{i, j});
                check[i][j] = true;
                
                while(!que.isEmpty()) {
                    int[] now = que.poll();
                    
                    int nowRow = now[0];
                    int nowCol = now[1];
                    
                    cnt += map[nowRow][nowCol] - '0';
                    
                    for(int t = 0; t < 4; t++) {
                        int nextRow = nowRow + dx[t];
                        int nextCol = nowCol + dy[t];
                        
                        if(nextRow < 0 || nextRow >= rowLen || nextCol < 0 || nextCol >= colLen) continue;
                        if(check[nextRow][nextCol] || map[nextRow][nextCol] == 'X') continue;
                        
                        que.add(new int[]{nextRow, nextCol});
                        check[nextRow][nextCol] = true;
                    }
                }
                
                result.add(cnt);
            }
        }
        
        if(result.size() == 0) {
            return new int[]{-1};
        }
        
        Collections.sort(result);
        
        int[] arr = new int[result.size()];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = result.get(i);
        }

        
        return arr;
    }
}
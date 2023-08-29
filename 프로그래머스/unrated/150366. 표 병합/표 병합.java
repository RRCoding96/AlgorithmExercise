import java.util.*;

class Solution {
    
    String[][] board;
    int[][] group;
    // Map<String, Set<Pos>> map;
    
    int groupNum = 10000;
    
    public String[] solution(String[] commands) {
        board = new String[51][51];
        for(int i = 1; i <= 50; i++) {
            for(int j = 1; j <= 50; j++) {
                board[i][j] = "";
            }
        }
        
        group = new int[51][51];
        initGroup();
        
        // map = new HashMap<>();
        
        List<String> sb = new ArrayList<>();
        for(String command : commands) {
            
            // printBoard();
            // printGroup();
            
            String[] input = command.split(" ");
            String order = input[0];
            
            if(order.equals("UPDATE")) {
                // "UPDATE r c value"
                if(input.length == 4) {
                    int r = Integer.parseInt(input[1]);
                    int c = Integer.parseInt(input[2]);
                    String value = input[3];
                    
                    int groupNum = group[r][c];
                    // board[r][c] = value;
                    
                    for(int i = 1; i <= 50; i++) {
                        for(int j = 1; j <= 50; j++) {
                            if(group[i][j] == groupNum) {
                                board[i][j] = value;
                            }
                        }
                    }
                    
                    
                    // if(map.containsKey(value)) {
                    //     Set<Pos> set = map.get(value);
                    //     set.add(new Pos(r, c));
                    //     // map.put(value, set);
                    // } else {
                    //     Set<Pos> set = new HashSet<>();
                    //     set.add(new Pos(r, c));
                    //     map.put(value, set);
                    // }
                    
                } 
                // "UPDATE value1 value2"
                else if(input.length == 3) {
                    String value1 = input[1];
                    String value2 = input[2];
                    
                    for(int i = 1; i <= 50; i++) {
                        for(int j = 1; j <= 50; j++) {
                            if(board[i][j].equals(value1)) {
                                board[i][j] = value2;
                            }
                        }
                    }
                    
//                     if(!map.containsKey(value1)) continue;
                    
//                     Set<Pos> value2Set;
//                     if(map.containsKey(value2)) {
//                         value2Set = map.get(value2);
//                     } else {
//                         value2Set = new HashSet<>();
//                     }
                    
//                     Set<Pos> set = map.get(value1);
//                     for(Pos pos : set) {
//                         board[pos.x][pos.y] = value2;
//                         value2Set.add(new Pos(pos.x, pos.y));
//                     }
                    
//                     map.put(value2, value2Set);
//                     map.remove(value1);
                    
                }
            } else if(order.equals("MERGE")) {
                int r1 = Integer.parseInt(input[1]);
                int c1 = Integer.parseInt(input[2]);
                int r2 = Integer.parseInt(input[3]);
                int c2 = Integer.parseInt(input[4]);
                
                int groupNum1 = group[r1][c1];
                int groupNum2 = group[r2][c2];
                
                if(groupNum1 == groupNum2) continue;
                
                String v1 = board[r1][c1];
                String v2 = board[r2][c2];
                String temp = "";
                
                if(v1.equals("") && !v2.equals("")) {
                    temp = v2;
                } else if(!v1.equals("") && v2.equals("")) {
                    temp = v1;
                } else if(!v1.equals("") && !v2.equals("")) {
                    temp = v1;
                    // map.remove(v2);
                }
                
                updateGroupNumAndValue(groupNum1, groupNum2, temp);
                
            } else if(order.equals("UNMERGE")) {
                int r = Integer.parseInt(input[1]);
                int c = Integer.parseInt(input[2]);
                
                int num = group[r][c];
                String value = board[r][c];
                
                unmerge(num, r, c, value);
            } else if(order.equals("PRINT")) {
                int r = Integer.parseInt(input[1]);
                int c = Integer.parseInt(input[2]);
                
                if(board[r][c].equals("")) {
                    sb.add("EMPTY");
                } else {
                    sb.add(board[r][c]);
                }
                
            } 
        }
        
        String[] answer = new String[sb.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = sb.get(i);
        }
        
        return answer;
    }
    
    void updateGroupNumAndValue(int num1, int num2, String value) {
        
        // Set<Pos> set = new HashSet<>();
        
        for(int i = 1; i <= 50; i++) {
            for(int j = 1; j <= 50; j++) {
                if(group[i][j] == num1 || group[i][j] == num2) {
                    group[i][j] = groupNum;
                    board[i][j] = value;
                    // set.add(new Pos(i, j));
                }
            }
        }
        groupNum++;
        // map.put(value, set);
    }
    
    void unmerge(int num, int r, int c, String value) {
        for(int i = 1; i <= 50; i++) {
            for(int j = 1; j <= 50; j++) {
                if(group[i][j] == num) {
                    group[i][j] = 50 * (i - 1) + j;
                    board[i][j] = "";
                }
            }
        }
        
        board[r][c] = value;
    }
    
    void initGroup() {
        for(int i = 1; i <= 50; i++) {
            for(int j = 1; j <= 50; j++) {
                group[i][j] = 50 * (i - 1) + j;
            }
        }
    }
    
    static class Pos {
        int x, y;
        
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object obj) {
            return this.x == ((Pos) obj).x && this.y == ((Pos) obj).y;
        }
    }
    
    void printBoard() {
        for(int i = 1; i <= 50; i++) {
            for(int j = 1; j <= 50; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    void printGroup() {
        for(int i = 1; i <= 50; i++) {
            for(int j = 1; j <= 50; j++) {
                System.out.print(group[i][j] + " ");
            }
            System.out.println();
        }
    }
}
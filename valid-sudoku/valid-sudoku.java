class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0; i < 9; i++) {
            char[] line = board[i];
            Set<Character> set = new HashSet<>();
            for(char c : line) {
                if(c != '.' && set.contains(c)) {
                    return false;
                } else {
                    set.add(c);
                }
            }
        }
        
        for(int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                if(board[j][i] != '.' && set.contains(board[j][i])) {
                    return false;
                } else {
                    set.add(board[j][i]);
                }
            }
        }
        
        for(int r = 0; r <= 6; r += 3) {
            for(int c = 0; c <= 6; c += 3) {
                Set<Character> set = new HashSet<>();
                for(int i = r; i < r + 3; i++) {
                    for(int j = c; j < c + 3; j++) {
                        char cha = board[i][j];
                        if(cha != '.' && set.contains(cha)) {
                            return false;
                        } else {
                            set.add(cha);
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
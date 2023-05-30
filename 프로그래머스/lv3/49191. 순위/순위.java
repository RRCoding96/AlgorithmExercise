import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = n;
        
        int[][] check = new int[n + 1][n + 1];
        for(int[] rst : results) {
            int win = rst[0];
            int lose = rst[1];
            
            check[win][lose] = 1;
            check[lose][win] = -1;
        }
        
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(check[i][k] == 1 && check[k][j] == 1) {
                        check[i][j] = 1;
                        check[j][i] = -1;
                    }
                }
            }
        }
        
        // for(int i = 1; i <= n; i++) {
        //     for(int j = 1; j <= n; j++) {
        //         System.out.print(check[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) continue;
                
                if(check[i][j] == 0) {
                    answer--;
                    break;
                }
            }
        }
        
        
        return answer;
    }
}
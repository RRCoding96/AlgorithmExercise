class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int goalA = 0;
        int goalC = 0;
        // 목표치
        for(int i = 0; i < problems.length; i++){
            goalA = Math.max(problems[i][0], goalA);
            goalC = Math.max(problems[i][1], goalC);
        }
        
        // 처음부터 완료할 수 잇음
        if(goalA <= alp && goalC <= cop){
            return 0;
        }
        // 현재 점수가 더 높아도 목표 점수로 맞춰줌
        if(alp >= goalA){
            alp = goalA;
        }
        if(cop >= goalC){
            cop = goalC;
        }
        
        // dp 시작
        int[][] dp =new int[goalA + 2][goalC + 2];
        for(int i = alp; i <= goalA; i++){
            for(int j = cop; j <= goalC; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dp[alp][cop] = 0;
        
         for(int i = alp; i <= goalA; i++){
            for(int j = cop; j <= goalC; j++){
                
                // 그냥 알고리즘 공부함
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                
                // 문제 풀기
                for(int[] p : problems){
                    // 현재 상황의 능력으로 문제 풀 수 있으면
                    if(i >= p[0] && j >= p[1]){
                        // 문제 풀었을 때 목표 넘으면 목표 점수에 값 넣기
                        if(i + p[2] > goalA && j + p[3] > goalC){
                            dp[goalA][goalC] = Math.min(dp[goalA][goalC], dp[i][j] + p[4]);
                        } 
                        // 알고력만 넘으면
                        else if(i + p[2] > goalA){
                            dp[goalA][j + p[3]]=Math.min(dp[goalA][j + p[3]], dp[i][j] + p[4]);
                        }
                        // 코딩력만 넘으면
                        else if(j + p[3] > goalC){
                            dp[i + p[2]][goalC] = Math.min(dp[i + p[2]][goalC], dp[i][j] + p[4]);
                        }
                        // 두 능력 모두 목표 점수 이하면
                        else if(i + p[2] <= goalA && j + p[3] <= goalC){
                           dp[i + p[2]][j + p[3]] = Math.min(dp[i + p[2]][j + p[3]], dp[i][j] + p[4]); 
                        }
                    }
                                  
                }
            }
        }
        
        return dp[goalA][goalC];
    }
}
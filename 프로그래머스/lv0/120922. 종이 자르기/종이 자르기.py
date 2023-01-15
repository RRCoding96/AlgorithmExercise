def solution(M, N):
    answer = 0
    
    column = N-1
    singleRow = M-1
    totalRow = (M-1)*N
    
    answer = column + totalRow
    
    return answer
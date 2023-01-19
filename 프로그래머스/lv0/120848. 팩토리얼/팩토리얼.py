def solution(n):
    answer = 0
    
    multi = 1
    i = 1
    
    while True:
        multi *= i
        
        # if multi >= n:
        #     break
        if multi == n:
            return i
        if multi > n:
            return i-1
        
        i += 1

    
    return answer
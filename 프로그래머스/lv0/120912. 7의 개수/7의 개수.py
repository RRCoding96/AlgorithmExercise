def solution(array):
    answer = 0
    
    for i in array:
        n = i
        while n > 0:
            now = n % 10
            if now == 7:
                answer += 1
            
            n = n // 10
            
    
    return answer
def solution(n):
    answer = 0
    
    while n > 0:
        a = n % 10
        answer += a
        n //= 10
    
    return answer
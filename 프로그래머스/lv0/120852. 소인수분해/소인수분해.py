def solution(n):
    answer = []
    
    i = 2
    
    so = set()
    
    while n >= 2:
        if n % i == 0:
            so.add(i)
            n //= i
        else:
            i += 1
    
    answer = list(so)
    answer.sort()
    
    return answer
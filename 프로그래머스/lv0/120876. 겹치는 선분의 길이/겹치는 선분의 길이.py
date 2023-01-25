def solution(lines):
    answer = 0
    
    check = [0] * 300
    for line in lines:
        s = line[0] + 100
        e = line[1] + 100
        for i in range(s+1, e+1):
            check[i] += 1
    
    for i in check:
        if i >= 2:
            answer += 1
    
    
    return answer
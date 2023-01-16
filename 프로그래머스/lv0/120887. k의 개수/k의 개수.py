def solution(i, j, k):
    answer = 0
    
    root =''
    for a in range(i, j+1):
        root += str(a)
        
    rootArr = list(root)
    for s in rootArr:
        if s == str(k):
            answer += 1
    
    return answer
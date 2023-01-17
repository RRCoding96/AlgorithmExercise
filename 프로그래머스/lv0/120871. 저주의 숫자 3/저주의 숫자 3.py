def solution(n):
    answer = 0
    
    
    nNum = []
    nNum.append(0)
    for i in range(1, 1000):
        strNum = str(i)
        if (i % 3 == 0) or ('3' in strNum):
            continue
        nNum.append(i)
    
    answer = nNum[n]
    
    return answer
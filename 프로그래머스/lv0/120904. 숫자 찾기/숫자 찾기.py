def solution(num, k):
    answer = 0
    
    nNum = str(num)
    idx = nNum.find(str(k))
    
    if idx == -1:
        answer = idx
    else :
        answer = idx + 1
    
    return answer
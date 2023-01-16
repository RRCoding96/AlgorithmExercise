def solution(s):
    answer = ''
    
    sList = list(s)
    sList = sorted(sList)
    
    for c in sList:
        n = sList.count(c)
        if n == 1:
            answer += c
         
    return answer
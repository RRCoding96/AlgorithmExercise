def solution(my_string):
    answer = ''
    
    strArr = list(my_string)
    
    for i in range(len(strArr)):
        now = strArr[i]
        if now in answer:
            continue
        
        answer += now
    
    return answer
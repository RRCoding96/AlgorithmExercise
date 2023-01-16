def solution(my_string, num1, num2):
    answer = ''
    
    nstr = list(my_string)
    
    c1 = nstr[num1]
    c2 = nstr[num2]
    
    nstr[num1] = c2
    nstr[num2] = c1
    
    for c in nstr:
        answer += c
    
    return answer
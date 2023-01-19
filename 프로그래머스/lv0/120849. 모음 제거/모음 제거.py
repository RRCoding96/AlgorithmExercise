def solution(my_string):
    answer = ''
    
    mom = ['a', 'e', 'i', 'o', 'u']
    strArr = list(my_string)
    for c in my_string:
        if c in mom:
            strArr.remove(c)
    
    answer = ''.join(strArr)
    
    return answer
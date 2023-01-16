def solution(my_string):
    answer = ''
    
    for c in my_string:
        if c.isupper():
            nc = c.lower()
            answer += nc
        else:
            nc = c.upper()
            answer += nc
    
    return answer
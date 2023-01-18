def solution(my_string):
    answer = 0
    
    is_num = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
    numbers = []
    nowStr = ''
    
    my_string = my_string + 'a'
    
#     if my_string[0] in is_num:
#         nowStr += my_string[0]
        
    
    for i in range(1, len(my_string)):
        if my_string[i-1] in is_num:
            nowStr += my_string[i-1]
            if not my_string[i] in is_num:
                numbers.append(nowStr)
                nowStr = ''
    
    for c in numbers:
        answer += int(c)
    
    return answer
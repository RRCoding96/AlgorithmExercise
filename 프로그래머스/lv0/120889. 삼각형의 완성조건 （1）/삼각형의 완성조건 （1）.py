def solution(sides):
    answer = 0
    
    sides.sort()
    
    maxLen = sides[2]
    othersLen = sides[0] + sides[1]
    
    if maxLen < othersLen:
        answer = 1
    else:
        answer = 2
    
    return answer
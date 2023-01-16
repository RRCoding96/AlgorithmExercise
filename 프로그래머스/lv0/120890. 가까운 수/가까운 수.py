
def solution(array, n):
    answer = 0
    
    minDiff = 999
    minNum = []
    for i in array:
        diff = abs(i - n)
        if diff < minDiff:
            minDiff = diff
            
    a = n - minDiff
    b = n + minDiff
    
    if a in array:
        answer = a
    else:
        answer = b
    
    
    return answer
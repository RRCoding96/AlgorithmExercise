def solution(array):
    answer = []
    
    maxNum = max(array)
    answer.append(maxNum)
    answer.append(array.index(maxNum))
    
    return answer
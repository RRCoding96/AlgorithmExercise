def solution(emergency):
    answer = [0] * len(emergency)
    
    sortArr = sorted(emergency, reverse=True)
    for i in range(len(sortArr)):
        now = sortArr[i]
        for j in range(len(emergency)):
            if now == emergency[j]:
                answer[j] = i+1
    
    return answer
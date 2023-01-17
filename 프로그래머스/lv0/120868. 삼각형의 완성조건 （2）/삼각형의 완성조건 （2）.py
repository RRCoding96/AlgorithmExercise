def solution(sides):
    answer = 0
    
    # sides 중 긴 변이 가장 길 때
    maxLen = max(sides)
    minLen = min(sides)
    exp = []
    for i in range(1, maxLen + 1):
        if maxLen < minLen + i:
            exp.append(i)
            answer += 1
    
    # 새로 구한게 가장 길 때
    for i in range(maxLen, maxLen + minLen + 1):
        if i < maxLen + minLen and not i in exp:
            answer += 1
    
    
    return answer
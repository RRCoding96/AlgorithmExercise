def solution(A, B):
    answer = 0
    
    stringCnt = len(A)
    root = list(A)
    branch = list(A)
    
    if A == B:
        return 0
    
    while stringCnt >= 0:
        
        c = branch.pop()
        branch.insert(0, c)
        
        answer += 1
        stringCnt -= 1
        
        for i in range(len(branch)):
            print(branch[i], end=" ")
        print()
        
        if branch == list(B):
            return answer
    
    return -1
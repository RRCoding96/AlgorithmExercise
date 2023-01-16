def solution(quiz):
    answer = []
    
    for nowStr in quiz:
        left, right = nowStr.split(' = ')
        left = left.split(' ')

        leftAns = 0
        rightAns = int(right)
        if left[1] == '+':
            leftAns = int(left[0]) + int(left[2])
        else :
            leftAns = int(left[0]) - int(left[2])
            
        if leftAns == rightAns:
            answer.append('O')
        else :
            answer.append('X')
        
    return answer
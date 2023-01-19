def solution(dots):
    answer = 0
    
    dots = sorted(dots, key=lambda a: (a[0], a[1]))
    print(dots)
    
    height = dots[1][1] - dots[0][1]
    width = dots[2][0] - dots[1][0]
    
    answer = height * width
    
    return answer
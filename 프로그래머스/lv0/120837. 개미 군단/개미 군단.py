def solution(hp):
    answer = 0
    
    gen = 0
    sol = 0
    work = 0
    
    gen = hp // 5
    hp %= 5
    
    sol = hp // 3
    hp %= 3
    
    work = hp
    
    return gen + sol + work
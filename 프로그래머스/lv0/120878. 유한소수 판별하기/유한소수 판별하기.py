def solution(a, b):
    answer = 0
    
    # 분자, 분모의 소인수 각각 구하기
    son = []
    mom = []
    
    for i in range(2, a+1):
        if a % i == 0:
            while a % i == 0:
                a //= i
                son.append(i)
                
    for i in range(2, b+1):
        if b % i == 0:
            while b % i == 0:
                b //= i
                mom.append(i)
    
    # print(son)
    # print(mom)
    
    for i in son:
        if i in mom:
            mom.remove(i)
            
    # print(mom)
    
    for i in mom:
        if i != 2 and i != 5:
            answer = 2
            return answer
    
    answer = 1
    
    return answer
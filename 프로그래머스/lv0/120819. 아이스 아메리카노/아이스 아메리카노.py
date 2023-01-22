def solution(money):
    answer = []
    
    maxDrink = money // 5500
    changes = money - (maxDrink * 5500)
    
    answer.append(maxDrink)
    answer.append(changes)
    
    return answer
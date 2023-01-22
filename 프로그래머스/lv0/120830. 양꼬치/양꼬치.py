def solution(n, k):
    answer = 0
    
    sheepCost = 12000 * n
    bonusDrink = n // 10
    drinkCost = (k - bonusDrink) * 2000
    
    answer = sheepCost + drinkCost
    
    return answer
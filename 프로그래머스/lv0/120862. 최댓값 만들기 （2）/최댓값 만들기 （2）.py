def solution(numbers):
    answer = 0
    
    numbers = sorted(numbers)
    
    a = 1
    b = 1
    for i in range(2):
        a *= numbers[i]
        b *= numbers[len(numbers)-1-i]
    
    answer = a if a > b else b
    
    return answer
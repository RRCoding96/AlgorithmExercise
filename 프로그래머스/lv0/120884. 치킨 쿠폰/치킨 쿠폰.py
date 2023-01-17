def solution(chicken):
    answer = 0
    
    service = 0
    coupon = chicken
    while coupon > 9:
        service = coupon // 10
        coupon = (coupon % 10) + service
        
        answer += service
    
    return answer
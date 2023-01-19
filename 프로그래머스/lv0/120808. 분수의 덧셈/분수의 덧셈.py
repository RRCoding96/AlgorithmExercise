import math

def solution(numer1, denom1, numer2, denom2):
    answer = []
    
    nNumer = (numer1 * denom2) + (numer2 * denom1)
    nDenom = denom1 * denom2
    
    nGcd = nNumer
    while True:
        nGcd = math.gcd(nNumer, nDenom)
        
        if nGcd == 1:
            break
        
        nNumer //= nGcd
        nDenom //= nGcd
    
    answer.append(nNumer)
    answer.append(nDenom)
    
    return answer
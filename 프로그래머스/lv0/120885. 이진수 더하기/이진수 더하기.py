def solution(bin1, bin2):
    answer = ''
    
    dec1 = int(bin1, 2)
    dec2 = int(bin2, 2)
    
    total = dec1 + dec2
    biTotal = bin(total)
    
    answer = biTotal[2:]
    
    return answer
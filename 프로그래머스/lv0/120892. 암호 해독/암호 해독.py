def solution(cipher, code):
    answer = ''
    
    if code == 1:
        return cipher
    
    for i in range(1, len(cipher)):
        index = i*code - 1
        if index >= len(cipher):
            break
        
        answer += cipher[index]
    
    return answer
def solution(spell, dic):
    answer = 2
    
    for dicSen in dic:
        dicSenArr = list(dicSen)
        
        if len(dicSenArr) != len(spell):
            continue
        
        for c in spell:
            if c in dicSenArr:
                dicSenArr.remove(c)
        #
        print(dicSenArr)
        #
        if len(dicSenArr) == 0:
            answer = 1
            return answer
    
    return answer
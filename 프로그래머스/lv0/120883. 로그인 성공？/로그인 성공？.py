def solution(id_pw, db):
    answer = ''
    
    id = id_pw[0]
    pw = id_pw[1]
    
    for now in db:
        nowId = now[0]
        nowPw = now[1]
        
        if id == nowId:
            if pw == nowPw:
                answer = 'login'
                return answer
            else:
                answer = 'wrong pw'
                return answer
        
        
    answer = 'fail'
    return answer
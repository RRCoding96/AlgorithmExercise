def solution(s):
    s_len = len(s)
    answer = s_len
    for step in range(1, s_len//2 + 1):
        zip = ''
        prev = s[0:step]
        count = 1
        for j in range(step, s_len, step):
            # 이전이랑 같은 덩어리면 count +1
            if prev == s[j:j+step]:
                count += 1
            else: # 다른 문자 나옴
                zip += str(count) + prev if count >= 2 else prev
                prev = s[j:j+step]
                count = 1
        # 남은거 붙이기
        zip += str(count) + prev if count >= 2 else prev
        # 최소값 찾기
        answer = min(answer, len(zip))
    
    return answer
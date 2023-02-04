def solution(N, stages):
    answer = []

    length = len(stages) # 사람 수

    for i in range(1, N + 1):
        # i 스테이지에 머물러있는 사람의 수 계산
        count = stages.count(i)

        # 실패율 계산
        if length == 0:
            fail = 0
        else:
            fail = count / length

        answer.append([i, fail])
        length -= count

    answer = sorted(answer, key=lambda x: -x[1])

    answer = [i[0] for i in answer]
    return answer
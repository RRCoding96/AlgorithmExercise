import sys

s0 = ['m', 'o', 'o']


def bt(n, depth, b_len):  # depth: 차수, # b_len: 이전 차수의 길이
    # 다음 길이
    new_len = 2 * b_len + depth + 3
    if n <= 3:  # n이 3 이하일 경우 바로 출력
        print(s0[n - 1])
        return

    if new_len < n:  # new_l이 n보다 작을 경우
        bt(n, depth + 1, new_len)  # depth(차수)를 하나 늘림. new_l이 n을 담을 수 있을 때까지
    else:
        # n은 b_len(이전 길이)보다 무조건 큼.
        # 가운데, 뒤 파트만 보면 됨
        # 가운데
        if b_len < n and n <= b_len + depth + 3:
            if n - b_len != 1:  # n-l = 1일때만 'm'이 있고 나머지는 'o'로 채워진다.
                print('o')
            else:
                print('m')
            return
        # 뒤
        else:  # b_len+depth+3 바깥에 있는 경우
            # [n - (b_len + depth + 3)]을 진행해서 다시 첫번째 파트로 돌아온 다음 처음부터 재귀를 돌리기 시작한다.
            bt(n - (b_len + depth + 3), 1, 3)


n = int(sys.stdin.readline().rstrip())
bt(n, 1, 3)
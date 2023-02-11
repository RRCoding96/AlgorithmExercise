import sys
from collections import deque


def rotate(original):
    new_r = len(original[0])
    new_c = len(original)
    new_sticker = [[0 for _ in range(new_c)] for _ in range(new_r)]

    que = deque()
    for i in range(len(original)):
        for j in range(len(original[0])):
            que.append(original[i][j])

    # 90도 돌림
    for j in range(new_c - 1, -1, -1):
        for i in range(new_r):
            new_sticker[i][j] = que.popleft()

    return new_sticker


def can_put_sticker_on_board(r_start, c_start, now_sticker):
    # print(f'board 시작 좌표: {r_start} {c_start}')
    global board
    stick_row_idx = 0
    for r in range(r_start, r_start + len(now_sticker)):
        stick_col_idx = 0
        for c in range(c_start, c_start + len(now_sticker[0])):
            # print(f'board 좌표: {r} {c}, 스티커 좌표: {stick_row_idx} {stick_col_idx}')
            if r < 0 or c < 0 or r >= N or c >= M:
                return False

            if now_sticker[stick_row_idx][stick_col_idx] == 1 and board[r][c] == 1:
                return False
            stick_col_idx += 1
        stick_row_idx += 1

    return True


def find_position(now_sticker):
    global board
    for r_start in range(N):
        for c_start in range(M):
            result = can_put_sticker_on_board(r_start, c_start, now_sticker)
            if result:
                return True, r_start, c_start

    return False, -1, -1


N, M, K = map(int, sys.stdin.readline().rstrip().split())

board = [[0 for _ in range(M)] for _ in range(N)]

# 스티커를 순서대로 받으면서 붙일 수 있는 곳에 붙임
# 0 -> 빈 칸 // 1 -> 스티커 붙은 칸
for p in range(1, K + 1):
    R, C = map(int, sys.stdin.readline().rstrip().split())
    sticker = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(R)]

    # 스티커 붙여봄
    for _ in range(4):

        # print(p, '번째 스티커 모양 확인')
        # print(*sticker, sep='\n')
        # print()

        # 노트북의 왼쪽 위 지점과 스티커의 왼쪽 위 지점을 시작으로 비교
        can_stick = find_position(sticker)

        # print(p, '번째 가능한 지 확인')
        # print(can_stick)

        # 스티커 붙일 수 있으면
        if can_stick[0]:
            stick_r_idx = 0
            for i in range(can_stick[1], can_stick[1] + len(sticker)):
                stick_c_idx = 0
                for j in range(can_stick[2], can_stick[2] + len(sticker[0])):
                    if sticker[stick_r_idx][stick_c_idx] == 1:
                        board[i][j] = sticker[stick_r_idx][stick_c_idx]
                    stick_c_idx += 1
                stick_r_idx += 1

            # print(p, '번째 스티커 붙이기')
            # print(*board, sep='\n')
            # print()

            break
        # 안되면 회전 시킴
        else:
            sticker = rotate(sticker)

answer = 0
for i in range(N):
    for j in range(M):
        if board[i][j] == 1:
            answer += 1

print(answer)

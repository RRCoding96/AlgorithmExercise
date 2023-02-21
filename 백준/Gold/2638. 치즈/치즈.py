import sys
from collections import deque

N, M = map(int, sys.stdin.readline().rstrip().split())

board = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def check_outer_air():
    global board

    air = [[False for _ in range(M)] for _ in range(N)]

    for j in range(M):
        que = deque()
        if air[0][j]:
            continue
        if board[0][j] != 0:
            continue
        que.append([0, j])
        air[0][j] = True

        while que:
            now_x, now_y = que.popleft()

            for t in range(4):
                nx = now_x + dx[t]
                ny = now_y + dy[t]

                if nx < 0 or ny < 0 or nx >= N or ny >= M:
                    continue
                if air[nx][ny]:
                    continue
                if board[nx][ny] != 0:
                    continue
                que.append([nx, ny])
                air[nx][ny] = True

    for i in range(1, N - 1):
        for j in [0, M - 1]:
            que = deque()
            if air[i][j]:
                continue
            if board[i][j] != 0:
                continue

            que.append([i][j])
            air[i][j] = True

            while que:
                now_x, now_y = que.popleft()

                for t in range(4):
                    nx = now_x + dx[t]
                    ny = now_y + dy[t]

                    if nx < 0 or ny < 0 or nx >= N or ny >= M:
                        continue
                    if air[nx][ny]:
                        continue
                    if board[nx][ny] != 0:
                        continue
                    que.append([nx, ny])
                    air[nx][ny] = True

    for j in range(M):
        que = deque()
        if air[N - 1][j]:
            continue
        if board[N - 1][j] != 0:
            continue
        que.append([N - 1][j])
        air[N - 1][j] = True

        while que:
            now_x, now_y = que.popleft()

            for t in range(4):
                nx = now_x + dx[t]
                ny = now_y + dy[t]

                if nx < 0 or ny < 0 or nx >= N or ny >= M:
                    continue
                if air[nx][ny]:
                    continue
                if board[nx][ny] != 0:
                    continue
                que.append([nx, ny])
                air[nx][ny] = True

    return air


def melt_cheese(air):
    global board

    for i in range(N):
        for j in range(M):
            if board[i][j] == 1:
                air_cnt = 0
                for t in range(4):
                    nx = i + dx[t]
                    ny = j + dy[t]

                    if nx < 0 or ny < 0 or nx >= N or ny >= M:
                        continue

                    if air[nx][ny]:
                        air_cnt += 1
                if air_cnt >= 2:
                    board[i][j] = 0


def is_continue():
    global board

    for i in range(N):
        for j in range(M):
            if board[i][j] == 1:
                return True
    return False


def solution():
    time = 0
    while True:
        # print(time)
        if not is_continue():
            break

        n_air = check_outer_air()

        # print('공기')
        # print(*n_air, sep='\n')

        melt_cheese(n_air)

        # print('치즈 녹인 뒤')
        # print(*board, sep='\n')

        time += 1

    print(time)


solution()

import sys

dx = [0, 0, -1, -1, -1, 0, 1, 1, 1] # 0인덱스는 그냥 0 넣음
dy = [0, -1, -1, 0, 1, 1, 1, 0, -1]

cx = [-1, -1, 1, 1] # 대각선 체크
cy = [-1, 1, -1, 1]

N, M = map(int, sys.stdin.readline().split())

board = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

# 초기 구름 위치 넣음
cloud = [[False for _ in range(N)] for _ in range(N)]
for i in range(N-2, N):
    for j in range(0, 2):
        cloud[i][j] = True

for _ in range(M):
    d, s = list(map(int, sys.stdin.readline().split()))
    # d = order[0] # 이동 방향
    # s = order[1] # 이동 거리

    # copy_board = [[0 for _ in range(N)] for _ in range(N)]
    # for i in range(N):
    #     for j in range(N):
    #         copy_board[i][j] = board[i][j]

    copy_cloud = [[False for _ in range(N)] for _ in range(N)] # 이동된 구름 기록

    # 구름 이동시키기 -> 범위 넘어가면 반대쪽으로 감
    for i in range(N):
        for j in range(N):
            if cloud[i][j]:
                # nx = i + dx[d] * s
                # ny = j + dy[d] * s
                # if nx >= N:
                #     nx %= N
                # if ny >= N:
                #     ny %= N
                # if nx < 0:
                #     nx = abs(nx) % N - 1
                # if ny < 0:
                #     ny = abs(ny) % N - 1

                nx = i
                ny = j
                for k in range(s):
                    nx += dx[d]
                    ny += dy[d]
                    # 범위 벗어나면 반대편으로 나타남
                    if nx < 0:
                        nx = N - 1
                    if ny < 0:
                        ny = N - 1
                    if nx >= N:
                        nx = 0
                    if ny >= N:
                        ny = 0
                copy_cloud[nx][ny] = True
                board[nx][ny] += 1

    # 비 내리기
    # for i in range(N):
    #     for j in range(N):
    #         if copy_cloud[i][j]:
    #             board[i][j] += 1

    # 대각선 방향 물 복사
    for i in range(N):
        for j in range(N):
            if copy_cloud[i][j]:
                for t in range(4):
                    nx = i + cx[t]
                    ny = j + cy[t]
                    if nx < 0 or ny < 0 or nx >= N or ny >= N:
                        continue
                    if board[nx][ny] > 0:
                        board[i][j] += 1

    # 구름 생기게 하기
    cloud = [[False for _ in range(N)] for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if board[i][j] >= 2 and not copy_cloud[i][j]:
                cloud[i][j] = True
                board[i][j] -= 2

result = 0
for i in range(N):
    for j in range(N):
        result += board[i][j]

print(result)
import sys
from collections import deque

N, K = map(int, sys.stdin.readline().split())

board = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

S, X, Y = map(int, sys.stdin.readline().split())

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

time = 0
arr = list()
for i in range(N):
    for j in range(N):
        if board[i][j] != 0:
            arr.append([board[i][j], time, i, j])

arr.sort()
que = deque(arr)

while que:
    now = que.popleft()

    nowValue = now[0]
    nowTime = now[1]
    nowX = now[2]
    nowY = now[3]

    if nowTime == S:
        # print(board)
        break

    for t in range(4):
        nx = nowX + dx[t]
        ny = nowY + dy[t]
        if nx < 0 or ny < 0 or nx >= N or ny >= N:
            continue
        if board[nx][ny] != 0:
            continue

        que.append([nowValue, nowTime + 1, nx, ny])
        board[nx][ny] = nowValue
    time += 1
    # print(board)

print(board[X-1][Y-1])

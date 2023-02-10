import sys
from collections import deque
import copy

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

N, M = map(int, sys.stdin.readline().rstrip().split())
board = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]

year = 0
while True:
    is_no = True
    for i in range(N):
        for j in range(M):
            if board[i][j] > 0:
                is_no = False
                break
        if not is_no:
            break

    if is_no:
        year = 0
        break

    copy_board = copy.deepcopy(board)
    year += 1
    # 녹이기
    for i in range(N):
        for j in range(M):
            if board[i][j] <= 0:
                continue
            touch = 0
            for t in range(4):
                nx = i + dx[t]
                ny = j + dy[t]
                if nx < 0 or ny < 0 or nx >= N or ny >= M:
                    continue
                if board[nx][ny] <= 0:
                    touch += 1
            copy_board[i][j] -= touch
    board = copy_board
    # print(*board, sep='\n')
    # print()

    # 덩어리 개수 세기
    is_visited = [[False for _ in range(M)] for _ in range(N)]
    cnt = 0
    for i in range(N):
        for j in range(M):
            if board[i][j] <= 0:
                continue
            if not is_visited[i][j]:
                que = deque()
                cnt += 1
                que.append([i, j])
                is_visited[i][j] = True

                while que:
                    now_x, now_y = que.popleft()
                    for t in range(4):
                        nx = now_x + dx[t]
                        ny = now_y + dy[t]
                        if nx < 0 or ny < 0 or nx >= N or ny >= M:
                            continue
                        if is_visited[nx][ny]:
                            continue
                        if board[nx][ny] <= 0:
                            continue
                        que.append([nx, ny])
                        is_visited[nx][ny] = True
    # print(cnt)
    if cnt >= 2:
        break

print(year)

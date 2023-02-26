import sys
from collections import deque

N, M = map(int, sys.stdin.readline().rstrip().split())
board = [list(sys.stdin.readline().rstrip()) for _ in range(N)]

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
visited = [[[[False for _ in range(M)] for _ in range(N)] for _ in range(M)] for _ in range(N)]


def roll(x, y, direction):
    cnt = 0

    while True:
        nx = x + dx[direction]
        ny = y + dy[direction]

        if board[nx][ny] == '#' or board[x][y] == 'O':
            break

        x = nx
        y = ny
        cnt += 1

    return x, y, cnt


def bfs(ra, rb, ba, bb):
    que = deque()
    que.append([ra, rb, ba, bb, 1])

    while que:
        rx, ry, bx, by, move_cnt = que.popleft()
        visited[rx][ry][bx][by] = True

        if move_cnt > 10:
            return -1

        for t in range(4):
            nrx, nry, rcnt = roll(rx, ry, t)
            nbx, nby, bcnt = roll(bx, by, t)

            if board[nbx][nby] != 'O':
                if board[nrx][nry] == 'O':
                    return move_cnt

                # 두 공이 겹치면 앞뒤 구분해서 재배치
                if nrx == nbx and nry == nby:
                    # 구슬이 더 많이 구름 -> 더 뒤쪽이었다는 뜻
                    if rcnt > bcnt:
                        nrx -= dx[t]
                        nry -= dy[t]
                    else:
                        nbx -= dx[t]
                        nby -= dy[t]

                if not visited[nrx][nry][nbx][nby]:
                    visited[nrx][nry][nbx][nby] = True
                    que.append([nrx, nry, nbx, nby, move_cnt + 1])

    return -1


a, b, c, d = 0, 0, 0, 0
for i in range(N):
    for j in range(M):
        if board[i][j] == 'R':
            a = i
            b = j
        if board[i][j] == 'B':
            c = i
            d = j

result = bfs(a, b, c, d)

print(result)

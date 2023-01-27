from collections import deque

T = int(input())

dx = [-2, -2, -1, 1, 2, 2, 1, -1]
dy = [-1, 1, 2, 2, 1, -1, -2, -2]

for _ in range(T):
    N = int(input())
    start = list(map(int, input().split()))
    target = list(map(int, input().split()))

    board = [[0 for _ in range(N)] for _ in range(N)]
    isVisited = [[False for _ in range(N)] for _ in range(N)]

    que = deque()
    que.append(start)
    isVisited[start[0]][start[1]] = True

    while not len(que) == 0:
        now = que.popleft()
        nowX = now[0]
        nowY = now[1]

        if nowX == target[0] and nowY == target[1]:
            print(board[nowX][nowY])
            break

        for t in range(8):
            nx = nowX + dx[t]
            ny = nowY + dy[t]

            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                continue
            if isVisited[nx][ny]:
                continue

            que.append([nx, ny])
            isVisited[nx][ny] = True
            board[nx][ny] = board[nowX][nowY] + 1


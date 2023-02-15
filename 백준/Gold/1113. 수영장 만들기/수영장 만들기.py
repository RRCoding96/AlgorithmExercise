from collections import deque
import sys

visited = []
res = 0


def solution():
    global res, visited

    def bfs(x, y, h):
        global res, visited

        que = deque([(x, y)])

        flag = True

        visited[x][y] = True
        cnt = 1
        while que:
            x, y = que.popleft()

            for t in range(4):
                nx = x + dx[t]
                ny = y + dy[t]
                # 수영장 밖으로 물이 넘치면
                if nx == -1 or nx == N or ny == -1 or ny == M:
                    flag = False
                    continue
                
                if board[nx][ny] <= h and not visited[nx][ny]:
                    visited[nx][ny] = True
                    que.append([nx, ny])
                    cnt += 1
        if flag:
            res += cnt
            # if not que:
            #     if flag:
            #         res += cnt
            #     return

    N, M = map(int, input().split())
    board = [list(map(int, list(sys.stdin.readline().rstrip()))) for _ in range(N)]

    dx = [-1, 0, 0, 1]
    dy = [0, -1, 1, 0]
    
    # 수면을 1부터 8까지 올리면서 확인
    for num in range(1, 9):
        visited = [[0] * M for _ in range(N)]
        for i in range(N):
            for j in range(M):
                # 현재 수면보다 낮고 아직 체크 안한 곳
                if board[i][j] <= num and not visited[i][j]:
                    bfs(i, j, num)
    print(res)


solution()

import sys
from collections import deque


def bfs(viruses):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    que = deque()
    # 바이러스 놓은 새로운 상태로 탐색 시작
    # n_board = [[0 for _ in range(N)] for _ in range(N)]
    isVisited = [[-1 for _ in range(N)] for _ in range(N)]

    for virus in viruses:
        que.append([virus[0], virus[1]])
        isVisited[virus[0]][virus[1]] = 0

    total_time = 0
    while que:
        now = que.popleft()

        nowX = now[0]
        nowY = now[1]
        nowTime = isVisited[nowX][nowY]

        for t in range(4):
            nx = nowX + dx[t]
            ny = nowY + dy[t]
            # 범위 체크
            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                continue

            if board[nx][ny] == 0 and isVisited[nx][ny] == -1:
                que.append([nx, ny])
                isVisited[nx][ny] = nowTime + 1
                total_time = max(total_time, nowTime + 1)
            elif board[nx][ny] == 2 and isVisited[nx][ny] == -1:
                que.append([nx, ny])
                isVisited[nx][ny] = nowTime + 1

    # if isVisited.count(-1) != wall_cnt:
    #     return 1e9
    if list(sum(isVisited, [])).count(-1) != wall_cnt:
        return 1e9

    return total_time


def find_case(depth, start):
    global min_
    if depth == M:
        # 바이러스 놓을 위치를 M개 고르면 BFS로 퍼트리기
        min_ = min(min_, bfs(viruses))

        return

    for i in range(start, len(virus_pos)):
        viruses.append(virus_pos[i])

        find_case(depth + 1, i + 1)

        viruses.pop()


N, M = map(int, sys.stdin.readline().split())

board = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]


wall_cnt = 0
# 바이러스 위치를 배열에 저장
virus_pos = []
for i in range(N):
    for j in range(N):
        if board[i][j] == 2:
            virus_pos.append([i, j])
        elif board[i][j] == 1:
            wall_cnt += 1

min_ = 1e9
# 바이러스 3개 고르는 경우
viruses = []

find_case(0, 0)

if min_ != 1e9:
    print(min_)
else:
    print(-1)

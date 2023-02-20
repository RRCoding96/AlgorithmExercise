import sys
import heapq
from collections import deque

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

N, M, fuel = map(int, sys.stdin.readline().rstrip().split())
board = [[0 for _ in range(N + 1)] for _ in range(N + 1)]

# 벽은 -1로 표시
for i in range(1, N + 1):
    line = list(map(int, sys.stdin.readline().rstrip().split()))
    for j in range(N):
        if line[j] == 1:
            board[i][j + 1] = -1

# 택시 시작위치
a, b = map(int, sys.stdin.readline().rstrip().split())
first_pos = [a, b]
# 승객 번호를 board에 표시
passenger_info = [[] for _ in range(M + 1)]
for p in range(1, M + 1):
    sa, sb, ea, eb = map(int, sys.stdin.readline().rstrip().split())
    passenger_info[p] = [sa, sb, ea, eb]
    board[sa][sb] = p

# print(*board, sep='\n')
# print('승객 리스트')
# print(*passenger_info, sep='\n')


def find_passenger(now_pos, start_fuel):
    global board
    que = []
    is_visited = [[False for _ in range(N + 1)] for _ in range(N + 1)]

    heapq.heappush(que, (0, now_pos[0], now_pos[1]))
    is_visited[now_pos[0]][now_pos[1]] = True

    while que:
        now_dist, now_x, now_y = heapq.heappop(que)

        if now_dist > start_fuel:
            return -1, -1, -1

        if board[now_x][now_y] > 0:
            return now_x, now_y, start_fuel - now_dist

        for t in range(4):
            nx = now_x + dx[t]
            ny = now_y + dy[t]

            if nx <= 0 or ny <= 0 or nx > N or ny > N:
                continue
            if board[nx][ny] == -1 or is_visited[nx][ny]:
                continue

            heapq.heappush(que, (now_dist + 1, nx, ny))
            is_visited[nx][ny] = True

    return -1, -1, -1


def move_passenger(start_pos, target_pos, target_num, start_fuel):
    global board
    que = deque()
    is_visited = [[False for _ in range(N + 1)] for _ in range(N + 1)]

    que.append([start_pos[0], start_pos[1], 0])
    is_visited[start_pos[0]][start_pos[1]] = True

    while que:
        now_x, now_y, now_dist = que.popleft()

        if now_dist > start_fuel:
            return -1, -1, -1

        if now_x == target_pos[0] and now_y == target_pos[1]:
            return now_x, now_y, start_fuel - now_dist

        for t in range(4):
            nx = now_x + dx[t]
            ny = now_y + dy[t]

            if nx <= 0 or ny <= 0 or nx > N or ny > N:
                continue
            if board[nx][ny] < 0 or is_visited[nx][ny]:
                continue

            que.append([nx, ny, now_dist + 1])
            is_visited[nx][ny] = True

    return -1, -1, -1


def solution():
    global fuel, board, first_pos
    answer = -1
    start_fuel = fuel
    start_pos = first_pos
    for _ in range(M):
        # 택시에서 가장 가까운 승객 찾기
        now_x, now_y, post_find_fuel = find_passenger(start_pos, start_fuel)
        now_passenger_num = board[now_x][now_y]

        # print('승객 번호: ', now_passenger_num)
        # print('남은 연료: post_find_fuel: ', post_find_fuel)

        board[now_x][now_y] = 0

        if post_find_fuel == -1:
            answer = -1
            break

        start_pos = [now_x, now_y]

        target_pos = passenger_info[now_passenger_num][2:]
        # print('target pos: ', target_pos)

        # 승객 태우고 이동
        now_x, now_y, post_move_fuel = move_passenger(start_pos, target_pos, now_passenger_num, post_find_fuel)

        # print('승객 태우고 온 목적지: ', now_x, now_y)
        # print('남은 연료: post_move_fuel: ', post_move_fuel)

        temp_fuel = post_find_fuel - post_move_fuel
        # print('temp: ', temp_fuel)

        if post_move_fuel == -1:
            answer = -1
            break

        start_pos = [now_x, now_y]
        start_fuel = post_move_fuel + 2 * temp_fuel
        # print('다음에 시작할 연료: ', start_fuel)
        answer = start_fuel

    print(answer)


solution()

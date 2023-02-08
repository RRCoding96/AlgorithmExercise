import sys


def blow_sands(total_sands, nowX, nowY, now_dir):
    global result, board
    left_sand = total_sands
    temp_total_sands = total_sands

    board[nowX][nowY] = 0
    if now_dir == 0:
        # 1, 7, 2, 10, 5, 10, 7, 2, 1, a
        bx = [-1, -1, -2, -1, 0, 1, 1, 2, 1, 0]
        by = [1, 0, 0, -1, -2, -1, 0, 0, 1, -1]
        for t in range(9):
            nx = nowX + bx[t]
            ny = nowY + by[t]
            b_sand = 0
            if t == 0 or t == 8:
                b_sand = int(total_sands * (1 / 100))
            elif t == 1 or t == 6:
                b_sand = int(total_sands * (7 / 100))
            elif t == 2 or t == 7:
                b_sand = int(total_sands * (2 / 100))
            elif t == 3 or t == 5:
                b_sand = int(total_sands * (10 / 100))
            elif t == 4:
                b_sand = int(total_sands * (5 / 100))

            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                result += b_sand
                left_sand -= b_sand
            else:
                left_sand -= b_sand
                board[nx][ny] += b_sand
        nx = nowX + bx[9]
        ny = nowY + by[9]
        if nx < 0 or ny < 0 or nx >= N or ny >= N:
            result += left_sand
        else:
            board[nx][ny] += left_sand

    elif now_dir == 1:
        # 1, 7, 2, 10, 5, 10, 7, 2, 1, a
        bx = [-1, 0, 0, 1, 2, 1, 0, 0, -1, 1]
        by = [-1, -1, -2, -1, 0, 1, 1, 2, 1, 0]
        for t in range(9):
            nx = nowX + bx[t]
            ny = nowY + by[t]
            b_sand = 0
            if t == 0 or t == 8:
                b_sand = int(total_sands * (1 / 100))
            elif t == 1 or t == 6:
                b_sand = int(total_sands * (7 / 100))
            elif t == 2 or t == 7:
                b_sand = int(total_sands * (2 / 100))
            elif t == 3 or t == 5:
                b_sand = int(total_sands * (10 / 100))
            elif t == 4:
                b_sand = int(total_sands * (5 / 100))

            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                result += b_sand
                left_sand -= b_sand
            else:
                left_sand -= b_sand
                board[nx][ny] += b_sand
        nx = nowX + bx[9]
        ny = nowY + by[9]
        if nx < 0 or ny < 0 or nx >= N or ny >= N:
            result += left_sand
        else:
            board[nx][ny] += left_sand
    elif now_dir == 2:
        # 1, 7, 2, 10, 5, 10, 7, 2, 1, a
        bx = [1, 1, 2, 1, 0, -1, -1, -2, -1, 0]
        by = [-1, 0, 0, 1, 2, 1, 0, 0, -1, 1]
        for t in range(9):
            nx = nowX + bx[t]
            ny = nowY + by[t]
            b_sand = 0
            if t == 0 or t == 8:
                b_sand = int(total_sands * (1 / 100))
            elif t == 1 or t == 6:
                b_sand = int(total_sands * (7 / 100))
            elif t == 2 or t == 7:
                b_sand = int(total_sands * (2 / 100))
            elif t == 3 or t == 5:
                b_sand = int(total_sands * (10 / 100))
            elif t == 4:
                b_sand = int(total_sands * (5 / 100))

            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                result += b_sand
                left_sand -= b_sand
            else:
                left_sand -= b_sand
                board[nx][ny] += b_sand
        nx = nowX + bx[9]
        ny = nowY + by[9]
        if nx < 0 or ny < 0 or nx >= N or ny >= N:
            result += left_sand
        else:
            board[nx][ny] += left_sand
    else:
        # 1, 7, 2, 10, 5, 10, 7, 2, 1, a
        bx = [1, 0, 0, -1, -2, -1, 0, 0, 1, -1]
        by = [1, 1, 2, 1, 0, -1, -1, -2, -1, 0]
        for t in range(9):
            nx = nowX + bx[t]
            ny = nowY + by[t]
            b_sand = 0
            if t == 0 or t == 8:
                b_sand = int(total_sands * (1 / 100))
            elif t == 1 or t == 6:
                b_sand = int(total_sands * (7 / 100))
            elif t == 2 or t == 7:
                b_sand = int(total_sands * (2 / 100))
            elif t == 3 or t == 5:
                b_sand = int(total_sands * (10 / 100))
            elif t == 4:
                b_sand = int(total_sands * (5 / 100))

            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                result += b_sand
                left_sand -= b_sand
            else:
                left_sand -= b_sand
                board[nx][ny] += b_sand
        nx = nowX + bx[9]
        ny = nowY + by[9]
        if nx < 0 or ny < 0 or nx >= N or ny >= N:
            result += left_sand
        else:
            board[nx][ny] += left_sand


N = int(sys.stdin.readline().rstrip())

board = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]

# 페이스메이커 만들기
track = [[0 for _ in range(N)] for _ in range(N)]
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

i = 0
j = 0
idx = 0
track_num = N * N
while True:

    track[i][j] = track_num

    if track_num == 1:
        break

    i += dx[idx]
    j += dy[idx]
    if i < 0 or j < 0 or i >= N or j >= N or track[i][j] != 0:
        i -= dx[idx]
        j -= dy[idx]
        idx = (idx + 1) % 4
        continue

    track_num -= 1

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

result = 0
now_x = N // 2
now_y = N // 2
now_track = 1
dir_ = 0
while True:
    if now_x == 0 and now_y == 0:
        break

    for t in range(4):
        nx = now_x + dx[t]
        ny = now_y + dy[t]
        if nx < 0 or ny < 0 or nx >= N or ny >= N:
            continue
        if track[nx][ny] == now_track + 1:
            now_x = nx
            now_y = ny
            blow_sands(board[now_x][now_y], now_x, now_y, t)
            break

    now_track += 1


print(result)

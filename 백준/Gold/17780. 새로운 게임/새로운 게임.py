import sys

# _, 오른, 왼, 위, 아래
dx = [0, 0, 0, -1, 1]
dy = [0, 1, -1, 0, 0]

N, K = map(int, sys.stdin.readline().rstrip().split())
# 0: 흰, 1: 빨, 2: 파
board = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]

# 말 위치 기록
record = [[[] for _ in range(N)] for _ in range(N)]

horses_info = [[] for _ in range(K + 1)]
for i in range(1, K + 1):
    r, c, direction = map(int, sys.stdin.readline().rstrip().split())
    # 말 번호, 행, 열, 방향
    horses_info[i] = [i, r - 1, c - 1, direction]
    record[r - 1][c - 1].append(i)

# print(*board, sep='\n')
# print(*horses_info, sep='\n')
# print(*record, sep='\n')


def is_bottom_horse(h_num, x, y):
    horse_state = record[x][y]
    if horse_state[0] == h_num:
        return True
    else:
        return False


def reverse_dir(direction):
    if direction == 1:
        return 2
    elif direction == 2:
        return 1
    elif direction == 3:
        return 4
    elif direction == 4:
        return 3


def blue_plate(now_x, now_y, direction):
    rev_dir = reverse_dir(direction)

    nx = now_x + dx[rev_dir]
    ny = now_y + dy[rev_dir]

    if nx < 0 or ny < 0 or nx >= N or ny >= N or board[nx][ny] == 2:
        return now_x, now_y, reverse_dir(rev_dir)

    return nx, ny, rev_dir


def is_blue_again(x, y, direction):
    rev_dir = reverse_dir(direction)
    nnx = x + dx[rev_dir]
    nny = y + dy[rev_dir]

    if nnx < 0 or nny < 0 or nnx >= N or nny >= N or board[nnx][nny] == 2:
        return True
    return False


def move_next_pos(x, y, direction):
    nx = x + dx[direction]
    ny = y + dy[direction]

    # 판을 벗어나는 경우 or 파란칸
    if nx < 0 or ny < 0 or nx >= N or ny >= N or board[nx][ny] == 2:
        # new_x, new_y, new_dir = blue_plate(x, y, direction)
        # 또 벗어나거나 파란칸이면 이동 안하고 방향만 반대로
        if is_blue_again(x, y, direction):
            return x, y, reverse_dir(direction)
        else:
            rev_dir = reverse_dir(direction)

            return move_next_pos(x, y, rev_dir)

            # nx = x + dx[rev_dir]
            # ny = y + dy[rev_dir]
            # for value in record[x][y]:
            #     record[nx][ny].append(value)
            #     h_n, x, y, d = horses_info[value]
            #     horses_info[value] = [h_n, nx, ny, d]
            # record[x][y] = []
            # return nx, ny, direction
    # 빨강칸
    elif board[nx][ny] == 1:
        rev_horses = record[x][y][::-1]

        for value in rev_horses:
            record[nx][ny].append(value)
            h_n, x, y, d = horses_info[value]
            horses_info[value] = [h_n, nx, ny, d]

        record[x][y] = []
    # 흰칸
    elif board[nx][ny] == 0:

        for value in record[x][y]:
            record[nx][ny].append(value)
            h_n, x, y, d = horses_info[value]
            horses_info[value] = [h_n, nx, ny, d]

        record[x][y] = []

    return nx, ny, direction


def move_all_horses():
    for horse in range(1, K + 1):
        horse_num, r, c, direction = horses_info[horse]
        # 말이 가장 밑이 아니면 다음 말로 넘어감
        if not is_bottom_horse(horse_num, r, c):
            continue

        nx, ny, n_dir = move_next_pos(r, c, direction)
        horses_info[horse_num] = [horse_num, nx, ny, n_dir]

        # print(*record, sep='\n')
        # print(*horses_info, sep='\n')


def is_finish():
    for i in range(N):
        for j in range(N):
            if len(record[i][j]) >= 4:
                return True
    return False


answer = -1
time = 1
while time <= 1000:
    # print('time: ', time)
    move_all_horses()

    if is_finish():
        answer = time
        break

    time += 1

print(answer)

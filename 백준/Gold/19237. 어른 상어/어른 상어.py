import sys, copy

# 공백, 위, 아래, 왼쪽, 오른쪽
dx = [0, -1, 1, 0, 0]
dy = [0, 0, 0, -1, 1]

N, M, K = map(int, sys.stdin.readline().rstrip().split())
board = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]

# print('처음 상어 별 현재 위치')
shark_now_pos = [[]] * (M + 1)
check = [[0 for _ in range(N)] for _ in range(N)]  # 겹치는 상어 체크할 배열
for i in range(N):
    for j in range(N):
        if board[i][j] != 0:
            shark_now_pos[board[i][j]] = [i, j]
            check[i][j] = board[i][j]
            board[i][j] = [board[i][j], 0]

# print(shark_now_pos)

# print('상어 별 현재 방향')
shark_now_dir = list(map(int, sys.stdin.readline().rstrip().split()))
shark_now_dir.insert(0, 0)
# print(shark_now_dir)

shark_priority_info = [[0 for _ in range(5)] for _ in range(M + 1)]
for i in range(1, M + 1):
    temp = []
    for j in range(1, 5):
        temp = list(map(int, sys.stdin.readline().rstrip().split()))
        shark_priority_info[i][j] = temp
# print('상어 별 이동 우선순위')
# print(*shark_priority_info, sep='\n')


def check_shark_move_pos(shark_num, shark_pos, direction, dir_priority):
    global n_board
    x = shark_pos[0]
    y = shark_pos[1]

    check[x][y] = 0
    now_shark_smell_pos = []
    # 아무 냄새 없는 칸이 있으면 거기로 이동
    for t in range(4):
        target_dir = dir_priority[t]
        nx = x + dx[target_dir]
        ny = y + dy[target_dir]
        if nx < 0 or ny < 0 or nx >= N or ny >= N:
            continue

        if board[nx][ny] != 0 and len(board[nx][ny]) > 0 and board[nx][ny][0] == shark_num:
            now_shark_smell_pos.append([nx, ny, target_dir])

        # 아무 냄새 없는 칸으로 이동
        if board[nx][ny] == 0 or len(board[nx][ny]) == 0:
            n_shark_pos = [nx, ny]
            n_direction = target_dir

            # 일단 이동 시킴
            n_board[nx][ny].append(shark_num)

            return n_shark_pos, n_direction

    # 주위에 아무 냄새 없는 칸이 없으면 자신의 냄새가 있는 칸으로 이동
    n_board[now_shark_smell_pos[0][0]][now_shark_smell_pos[0][1]].append(shark_num)
    return [now_shark_smell_pos[0][0], now_shark_smell_pos[0][1]], now_shark_smell_pos[0][2]

    # return shark_pos, direction


def check_dup_and_record_smell(now_time):
    global n_board

    # print('일단 이동 시킨 상어들의 상태 출력')
    # print(*n_board, sep='\n')

    # 삭제할 상어 기록
    delete_shark_num = []
    for i in range(N):
        for j in range(N):
            # 상어가 있는 위치라면
            if len(n_board[i][j]) >= 1:
                # 맨 앞에 있는 상어의 냄새만 기록
                board[i][j] = [n_board[i][j][0], now_time]
                check[i][j] = n_board[i][j][0]
                # 그 뒤의 상어들은 삭제 리스트에 추가, 살아있는 상어 리스트에서 제거
                for k in range(1, len(n_board[i][j])):
                    shark_now_pos[n_board[i][j][k]] = []
                    shark_now_dir[n_board[i][j][k]] = 0

                    delete_shark_num.append(n_board[i][j][k])

    for i in range(N):
        for j in range(N):
            if check[i][j] in delete_shark_num:
                check[i][j] = 0


def move_all_shark(now_time):
    global board

    for num in range(1, M + 1):
        # 현재 상어의 현재 위치
        shark_pos = shark_now_pos[num]
        # 현재 상어가 격자 안에 있는지 체크 -> 없으면 넘어감
        if len(shark_pos) == 0:
            continue

        now_dir = shark_now_dir[num]
        now_dir_priority = shark_priority_info[num][now_dir]

        # 현재 상어 일단 이동 시킴
        n_shark_pos, n_direction = check_shark_move_pos(num, shark_pos, now_dir, now_dir_priority)

        # 일단 다른 상어랑 겹치는건 생각 안하고 기록 함
        shark_now_dir[num] = n_direction
        shark_now_pos[num] = n_shark_pos

    check_dup_and_record_smell(now_time)


def erase_smell(now_time):
    global board
    target_smell_time = now_time - K
    for i in range(N):
        for j in range(N):
            if board[i][j] == 0 or len(board[i][j]) == 0:
                continue
            smell = board[i][j]
            if smell[1] <= target_smell_time:
                board[i][j] = []


def is_finish():
    for k in range(2, M + 1):
        if len(shark_now_pos[k]) > 0:
            return False
    return True


answer = -1
time = 1
while time <= 1000:
    n_board = [[[] for _ in range(N)] for _ in range(N)]

    # print('현재 시간: ', time)
    move_all_shark(time)

    # print('이동 뒤의 상어들 정보')
    # print('상어 위치 기록')
    # print(shark_now_pos)
    #
    # print('상어 방향')
    # print(shark_now_dir)
    #
    # print('냄새 기록')
    # print(*board, sep='\n')
    #
    # print('현재 상어 위치 기록')
    # print(*check, sep='\n')

    erase_smell(time)

    # print('냄새 지운 뒤 기록')
    # print(*board, sep='\n')

    if is_finish():
        answer = time
        break

    time += 1
    # print()
    # print()

print(answer)

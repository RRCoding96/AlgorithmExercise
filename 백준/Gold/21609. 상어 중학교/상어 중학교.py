import sys
from collections import deque

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

N, M = map(int, sys.stdin.readline().rstrip().split())

board = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]


# 지울 구역 찾기
def find_section():
    global board
    sections = []
    for i in range(N):
        for j in range(N):
            if board[i][j] > -1:
                temp = []  # 그룹이 가능한 경우 그룹을 이루는 좌표들
                root_temp = []  # 그룹에서 기준 블록이 될 수 있는 블록들
                rainbow_cnt = 0  # 무지개 블록 개수

                checked = [[False for _ in range(N)] for _ in range(N)]
                que = deque()

                common_color = -4  # 일반 블록 색 저장할 변수
                if board[i][j] != 0:
                    common_color = board[i][j]

                que.append([i, j])
                checked[i][j] = True

                while que:
                    x, y = que.popleft()

                    # 무지개 색 블럭 세기
                    if board[x][y] == 0:
                        rainbow_cnt += 1
                    # 기준 블록 후보들 넣기
                    if board[x][y] > 0:
                        root_temp.append([x, y])
                    # 그룹 가능한 블럭들 넣기
                    temp.append([x, y])

                    for t in range(4):
                        nx = x + dx[t]
                        ny = y + dy[t]

                        if nx < 0 or ny < 0 or nx >= N or ny >= N:
                            continue
                        if checked[nx][ny] or board[nx][ny] <= -1:
                            continue
                        if common_color < 0 and board[nx][ny] > 0:
                            common_color = board[nx][ny]
                        if board[nx][ny] > 0 and board[nx][ny] != common_color:
                            continue

                        que.append([nx, ny])
                        checked[nx][ny] = True

                if common_color == -4:
                    continue

                root_temp.sort(key=lambda x: (x[0], x[1]))

                if len(temp) > 1:
                    sections.append([temp,
                                     rainbow_cnt,
                                     root_temp[0]])

    sections = sorted(sections, key=lambda arr: (-len(arr[0]), -arr[1], -arr[2][0], -arr[2][1]))

    if len(sections) > 0:
        return sections[0][0]
    else:
        return []


def delete_section(section):
    global board

    for pos in section:
        x = pos[0]
        y = pos[1]

        board[x][y] = -5

    return len(section) * len(section)


def gravity():
    global board
    for c in range(N):
        idx = N - 1
        for r in range(N - 1, -1, -1):
            if board[r][c] >= 0 and idx > r:
                board[idx][c] = board[r][c]
                board[r][c] = -5
                idx -= 1
            if board[r][c] != -5:
                idx = r - 1


def rotate():
    global board
    que = deque()
    for i in range(N):
        for j in range(N):
            que.append(board[i][j])

    for j in range(N):
        for i in range(N - 1, -1, -1):
            board[i][j] = que.popleft()


def solution():
    answer = 0

    while True:
        section = find_section()
        # print('그룹들')
        # print(section)

        if len(section) == 0:
            break

        answer += delete_section(section)

        # print('지우고 나서')
        # print(*board, sep='\n')

        gravity()
        # print('중력1')
        # print(*board, sep='\n')

        rotate()
        # print('돌리고 나서')
        # print(*board, sep='\n')

        gravity()
        # print('중력 2')
        # print(*board, sep='\n')

        # print(answer)

    print(answer)


solution()

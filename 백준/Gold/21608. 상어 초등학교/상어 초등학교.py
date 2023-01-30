import sys

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

N = int(input())

student_len = N*N
board = [[0 for _ in range(N)] for _ in range(N)]

students = []
for _ in range(student_len):
    students.append(list(map(int, sys.stdin.readline().split())))

for student in students:
    number = student[0]
    able_position = []
    for i in range(N):
        for j in range(N):
            if board[i][j] == 0:
                like = 0
                blank = 0
                for t in range(4):
                    nx = i + dx[t]
                    ny = j + dy[t]
                    if nx < 0 or ny < 0 or nx >= N or ny >= N:
                        continue
                    if board[nx][ny] in student[1:]:
                        like += 1
                    if board[nx][ny] == 0:
                        blank += 1
                able_position.append([like, blank, i, j])
    able_position.sort(key=lambda x:(-x[0], -x[1], x[2], [3]))
    board[able_position[0][2]][able_position[0][3]] = number

happy = 0
students.sort()

for i in range(N):
    for j in range(N):
        like_cnt = 0
        num = board[i][j]
        for t in range(4):
            nx = i + dx[t]
            ny = j + dy[t]
            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                continue
            if board[nx][ny] in students[num-1][1:]:
                like_cnt += 1
        if like_cnt != 0:
            happy += (10 ** (like_cnt - 1))

print(happy)




board = [[0 for _ in range(110)] for _ in range(110)]

N = int(input())

# 위치 찍어놓기
for _ in range(N):
    a, b = map(int, input().split())

    for i in range(a, a + 10):
        for j in range(b, b + 10):
            board[i][j] = 1


for i in range(99):
    for j in range(100):
        if board[i][j] != 0 and board[i + 1][j] != 0:
            board[i + 1][j] = board[i][j] + 1


# # 로그 찍기
# for r in range(101):
#     for c in range(101):
#         print(board[r][c], end=' ')
#     print()

answer = 0
for i in range(100):
    for j in range(100):
        h = 100

        for k in range(j, 100):
            h = min(h, board[i][k])
            if h == 0:
                break
            answer = max(answer, h * (k - j + 1))

print(answer)



from collections import deque

def print_board(board):
    for i in range(len(board)):
        for j in range(len(board[i])):
            print(board[i][j], end=' ')
        print()



def find_space(board):
    space = []
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    isVisited = [[False for _ in range(len(board[0]))] for _ in range(len(board))]

    for i in range(len(board)):
        for j in range(len(board[i])):
            if board[i][j] == 0 and not isVisited[i][j]:
                que = deque()

                que.append([i, j])
                isVisited[i][j] = True
                cnt = 1
                while not len(que) == 0:
                    now = que.popleft()
                    nowX = now[0]
                    nowY = now[1]

                    for t in range(len(dx)):
                        nx = nowX + dx[t]
                        ny = nowY + dy[t]

                        if nx < 0 or ny < 0 or nx >= len(board) or ny >= len(board[0]):
                            continue
                        if board[nx][ny] != 0:
                            continue
                        if isVisited[nx][ny]:
                            continue

                        que.append([nx, ny])
                        isVisited[nx][ny] = True
                        cnt += 1
                space.append(cnt)

    return sorted(space)



M, N, K = map(int, input().split())

board = [[0 for _ in range(N)] for _ in range(M)]

position = []
for _ in range(K):
    position.append(list(map(int, input().split())))

for pos in position:
    x1 = pos[0]
    x2 = pos[2]
    y1 = pos[1]
    y2 = pos[3]
    for i in range(y1, y2):
        for j in range(x1, x2):
            board[i][j] = 1


# print_board(board)

result = find_space(board)

print(len(result))
for n in result:
    print(n, end=' ')

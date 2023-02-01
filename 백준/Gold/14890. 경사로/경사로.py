import sys

N, L = map(int, sys.stdin.readline().split())

board = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

def check(line, L):
    visited = [False for _ in range(N)]
    for i in range(0, N-1):
        if line[i] == line[i+1]:
            continue
        elif abs(line[i]-line[i+1]) > 1:
            return False
        elif line[i] > line[i+1]:
            temp = line[i+1]
            for j in range(i+1, i+L+1):
                if 0 <= j < N:
                    if temp != line[j]:
                        return False
                    elif visited[j]:
                        return False
                    visited[j] = True
                else:
                    return False
        else:
            temp = line[i]
            for j in range(i, i-L, -1):
                if 0 <= j < N:
                    if temp != line[j]:
                        return False
                    elif visited[j]:
                        return False
                    visited[j] = True
                else:
                    return False
    return True

answer = 0
for g in board:
    if check(g, L):
        answer += 1

for i in range(N):
    temp = []
    for j in range(N):
        temp.append(board[j][i])
    if check(temp, L):
        answer += 1

print(answer)
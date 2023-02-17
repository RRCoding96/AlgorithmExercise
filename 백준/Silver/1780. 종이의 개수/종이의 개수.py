import sys


def separate(x, y, z):
    global answer

    temp = graph[x][y]
    # 반복문을 통해 종이를 확인
    for i in range(x, x + z):
        for j in range(y, y + z):
            # 시작점에 종이의 수가 현재 종이의 수와 다르다면
            if graph[i][j] != temp:
                # 3 * 3 범위를 재귀적으로 탐색
                for k in range(3):
                    for l in range(3):
                        separate(x + k * z // 3, y + l * z // 3, z // 3)
                return

    # 카운트
    if temp == -1:
        answer[0] += 1
    elif temp == 0:
        answer[1] += 1
    else:
        answer[2] += 1


n = int(sys.stdin.readline())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
answer = [0, 0, 0]
separate(0, 0, n)

for v in answer:
    print(v)
import sys


# 세로선의 결과 확인하는 함수
def check():
    # i번 세로선의 결과가 i번이 나오는지 체크
    for i in range(n):
        temp = i  # 이동하는 세로선 위치
        # 밑으로 내려가는
        for j in range(h):
            if graph[j][temp]:  # 오른쪽이 1인 경우
                temp += 1
            elif temp > 0 and graph[j][temp - 1]:  # 왼쪽이 1인 경우
                temp -= 1

        if temp != i:
            return False
    return True


# depth : 만든 가로선의 개수
def dfs(depth, x, y):
    global ans
    if ans <= depth:  # 가로선을 정답보다 많이 만든 경우 확인 필요 x
        return
    if check():  # i번 세로선의 결과가 i번이 나오는지 체크
        ans = min(ans, depth)
        return
    if depth == 3:
        return

    # 새로운 다리 놓기
    # 현재 시작 높이 부터 아래로 내려오면서
    for i in range(x, h):
        # 같은 세로줄 확인하면 y부터 확인. 세로줄 다르면 0부터
        k = y if i == x else 0
        for j in range(k, n - 1):
            # 0인 경우 가로줄 만들고, 연속된 가로선을 만들지 않기 위해 j + 2호출
            if graph[i][j] == False:
                graph[i][j] = True

                dfs(depth + 1, i, j + 2)

                graph[i][j] = False


# 세로, 가로, 세로선마다 가로선을 놓을수 있는 위치 수
n, m, h = map(int, sys.stdin.readline().split())
graph = [[False] * n for _ in range(h)]

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())  # 가로, 세로선
    graph[a - 1][b - 1] = True

# 추가해야 하는 가로선 개수가 4 이상이면 안됨(초기값)
ans = 4

dfs(0, 0, 0)

print(ans if ans <= 3 else -1)

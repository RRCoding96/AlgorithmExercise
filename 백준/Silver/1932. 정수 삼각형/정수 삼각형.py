import sys

n = int(sys.stdin.readline().rstrip())

dx = [1, 1]
dy = [0, 1]

arr = []
for _ in range(n):
    arr.append(list(map(int, sys.stdin.readline().rstrip().split())))

dp = [[0 for _ in range(n)] for _ in range(n)]
dp[0][0] = arr[0][0]

for i in range(0, n-1):
    for j in range(len(arr[i])):
        for t in range(2):
            nx = i + dx[t]
            ny = j + dy[t]

            # if ny >= len(arr[i+1]):
            #     continue

            dp[nx][ny] = max(dp[i][j] + arr[nx][ny], dp[nx][ny])

# print(*dp, sep='\n')


result_max = 0
for j in range(n):
    result_max = max(result_max, dp[n-1][j])

print(result_max)

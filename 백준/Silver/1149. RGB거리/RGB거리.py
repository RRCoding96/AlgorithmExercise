import sys

N = int(sys.stdin.readline().rstrip())

order = [[0, 0, 0]]
for i in range(1, N + 1):
    r, g, b = map(int, sys.stdin.readline().rstrip().split())
    order.append([r, g, b])

dp = [[0, 0, 0] for _ in range(N + 1)]

dp[1] = order[1]
for i in range(2, N + 1):
    dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + order[i][0]
    dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + order[i][1]
    dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + order[i][2]

print(min(dp[N][0], dp[N][1], dp[N][2]))

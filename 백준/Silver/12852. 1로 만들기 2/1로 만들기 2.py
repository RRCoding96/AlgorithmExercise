N = int(input())

dp = [0 for _ in range(N + 1)]
his = [[] for _ in range(N + 1)]

dp[1] = 0
his[1] = [1]

for i in range(2, N + 1):
    dp[i] = dp[i - 1] + 1
    his[i] = i - 1

    if i % 2 == 0 and dp[i] > dp[i // 2] + 1:
        dp[i] = dp[i // 2] + 1
        his[i] = i // 2
    if i % 3 == 0 and dp[i] > dp[i // 3] + 1:
        dp[i] = dp[i // 3] + 1
        his[i] = i // 3

print(dp[N])
h = N
while True:
    print(h, end=' ')
    if h == 1:
        break
    h = his[h]

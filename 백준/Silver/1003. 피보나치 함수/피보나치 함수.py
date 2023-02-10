n = int(input())

dp = [[1, 0] for _ in range(41)]
# print(*dp, sep='\n')
dp[1] = [0, 1]
dp[2] = [1, 1]

# print(*dp, sep='\n')

for i in range(3, 41):
    zero = dp[i - 1][0] + dp[i - 2][0]
    one = dp[i - 1][1] + dp[i - 2][1]
    dp[i][0] = zero
    dp[i][1] = one
    # dp[i] = [zero, one]

for _ in range(n):
    a = int(input())
    print(dp[a][0], dp[a][1])

# print(*dp, sep='\n')

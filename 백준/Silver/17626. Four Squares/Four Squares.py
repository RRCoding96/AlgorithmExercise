n = int(input())

dp = [0] * (n + 1)

dp[1] = 1
# dp[2] = 2
# dp[3] = 3

# idx = 2
# num = idx ** 2
# while num <= n:
#     dp[num] = 1
#     idx += 1
#     num = idx ** 2

# if n <= 3:
#     print(dp[n])
#     exit(0)

min_ = 0
for i in range(2, n + 1):
    x = int(i ** (1 / 2))
    min_ = 1e9
    # dp[i] = 1 + dp[i - x**2]
    for j in range(1, x+1):
        temp = i - j * j
        min_ = min(min_, dp[temp])
    dp[i] = min_ + 1

# print(dp)
print(dp[n])

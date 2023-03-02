import sys

N = int(sys.stdin.readline().rstrip())

arr = list(map(int, sys.stdin.readline().rstrip().split()))

dp = [0] * 1001

for i in range(N):
    dp[i] = arr[i]

for i in range(N):
    for j in range(i):
        if arr[i] > arr[j]:
            dp[i] = max(dp[i], dp[j] + arr[i])

# print(dp)
print(max(dp))



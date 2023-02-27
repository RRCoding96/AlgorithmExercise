n = int(input())

dp = [False] * 1001

# SK가 이기는 경우 : True, CY가 이기는 경우 : False
dp[1] = True
dp[3] = True
dp[4] = True

if n >= 5:
    for i in range(5, n + 1):
        if not dp[i - 1]:
            dp[i] = True
        if not dp[i - 3]:
            dp[i] = True
        if not dp[i - 4]:
            dp[i] = True

if dp[n]:
    print('SK')
else:
    print('CY')

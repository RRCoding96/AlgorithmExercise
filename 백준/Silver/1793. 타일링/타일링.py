while True:
    try:
        n = int(input())
        dp = [0] * (n + 1)

        if n < 1:
            print(1)
            continue
        dp[0] = 1
        dp[1] = 1
        for i in range(2, n + 1):
            dp[i] = dp[i - 1] + 2 * dp[i - 2]

        print(dp[n])
    except:
        break

import sys

N = int(sys.stdin.readline().rstrip())

soldiers = list(map(int, sys.stdin.readline().rstrip().split()))

# 처음엔 군인 1명이 기본으로 있음
dp = [1] * (N + 1)

# 한 명을 기준으로
for i in range(1, N):
    # 그 군인 까지의 앞까지 탐색하며
    for j in range(i):
        # 내림차순이 맞다면
        if soldiers[i] < soldiers[j]:
            # dp 계산
            dp[i] = max(dp[i], dp[j] + 1)

# 열외해야 하는 병사의 수를 구함
print(len(soldiers) - max(dp))

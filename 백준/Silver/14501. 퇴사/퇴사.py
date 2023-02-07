
N = int(input())

t = []
m = []
for _ in range(N):
   x, y = map(int, input().split())
   t.append(x)
   m.append(y)

dp = [0] * (N + 1)
max_value = 0
# 뒤쪽 부터 날짜 별로
for i in range(N-1, -1, -1):
    time = t[i] + i
    # 현재 날짜에서 상담이 끝나는 시간이 퇴사 전인지 체크
    if time <= N:
        # 현재 까지의 최고 이익 계산
        dp[i] = max(m[i] + dp[time], max_value)
        max_value = dp[i]
    else:
        dp[i] = max_value

# 거꾸로 가면서 최고 이익을 구해 출력
print(max_value)
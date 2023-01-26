N, K = map(int, input().split())

coins = list()
for i in range(N):
    coins.append(int(input()))

result = 0
for i in range(len(coins)-1, -1, -1):
    nowCoin = coins[i]
    mok = K // nowCoin
    nam = K % nowCoin
    if mok == 0:
        continue
    result += mok
    K = nam

print(result)
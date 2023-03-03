N, M = map(int, input().split())

cards = list(map(int, input().split()))

# print(cards)

max_sum = 0
for i in range(0, N):
    for j in range(i + 1, N):
        for r in range(j + 1, N):
            total = cards[i] + cards[j] + cards[r]
            if total <= M and total > max_sum:
                max_sum = total

print(max_sum)

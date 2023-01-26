n, m = map(int, input().split())

cards = list(map(int, input().split()))

for t in range(m):
    cards = sorted(cards)
    nNum = cards[0] + cards[1]
    cards[0] = nNum
    cards[1] = nNum

print(sum(cards))
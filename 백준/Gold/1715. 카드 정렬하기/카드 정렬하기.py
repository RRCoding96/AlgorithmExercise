import heapq

N = int(input())

card_count = []
for _ in range(N):
    data = int(input())
    heapq.heappush(card_count, data)

result = 0

while len(card_count) != 1:
    a = heapq.heappop(card_count)
    b = heapq.heappop(card_count)

    sum_ = a + b
    result += sum_
    heapq.heappush(card_count, sum_)

print(result)

N = int(input())
ropes = list()
for i in range(N):
    ropes.append(int(input()))

ropes.sort(reverse=True)

max_weight = 0
for i in range(len(ropes)):
    weight = ropes[i] * (i + 1)
    max_weight = max(max_weight, weight)

print(max_weight)
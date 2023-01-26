N = int(input())
scores = list()
for i in range(N):
    scores.append(int(input()))

result = 0
for i in range(len(scores)-1, 0, -1):
    if scores[i] <= scores[i-1]:
        diff = scores[i-1] - scores[i]
        scores[i-1] = scores[i-1] - (diff + 1)
        result += (diff + 1)

print(result)
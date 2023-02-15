import sys

INF = int(1e9)

# 지역 개수, 수색 범위, 길의 개수
n, m, r = map(int, sys.stdin.readline().rstrip().split())

item_point = list(map(int, sys.stdin.readline().rstrip().split()))
item_point.insert(0, 0)

# graph = [[] for _ in range(n + 1)]

table = [[INF for _ in range(n + 1)] for _ in range(n + 1)]
for i in range(1, n + 1):
    table[i][i] = 0

for _ in range(r):
    a, b, L = map(int, sys.stdin.readline().rstrip().split())
    table[a][b] = L
    table[b][a] = L
    # graph[a].append([b, l])
    # graph[b].append([a, l])

result = 0

for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            table[i][j] = min(table[i][j], table[i][k] + table[k][j])


for s in range(1, n + 1):
    total = 0
    for j in range(1, n + 1):
        if table[s][j] <= m:
            total += item_point[j]
        result = max(result, total)

print(result)




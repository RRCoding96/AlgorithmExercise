import sys

INF = int(1e9)

n = int(sys.stdin.readline().rstrip())  # 도시 개수
m = int(sys.stdin.readline().rstrip())  # 버스 개수

# 처음에는 모든 위치로 가는 데 INF의 시간이 걸린다고 해놓음
graph = [[INF for _ in range(n + 1)] for _ in range(n + 1)]
# 자기 자신은 0시간만에 가는 것으로 간주함
for i in range(1, n + 1):
    graph[i][i] = 0

for _ in range(m):
    a, b, c = map(int, sys.stdin.readline().rstrip().split())
    # 버스가 여러개 일 수 있어서 그 중 가장 비용이 적은 값이 들어가게 함
    graph[a][b] = min(graph[a][b], c)

# 플로이드-워셜 알고리즘
for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

for i in range(1, n + 1):
    for j in range(1, n + 1):
        if graph[i][j] != INF:
            print(graph[i][j], end=' ')
        else:
            print(0, end=' ')
    print()

import sys
import heapq

INF = int(1e9)

N = int(sys.stdin.readline().rstrip())
M = int(sys.stdin.readline().rstrip())

graph = [[] for _ in range(N + 1)]
for _ in range(M):
    s, e, c = map(int, sys.stdin.readline().rstrip().split())
    graph[s].append([e, c])

start, target = map(int, sys.stdin.readline().rstrip().split())

distance = [INF] * (N + 1)

def dijkstra(start):
    pque = []
    heapq.heappush(pque, (0, start))
    distance[start] = 0

    while pque:
        dist, now = heapq.heappop(pque)
        if distance[now] < dist:
            continue
        for node in graph[now]:
            cost = dist + node[1]
            if cost < distance[node[0]]:
                distance[node[0]] = cost
                heapq.heappush(pque, (cost, node[0]))

dijkstra(start)

print(distance[target])


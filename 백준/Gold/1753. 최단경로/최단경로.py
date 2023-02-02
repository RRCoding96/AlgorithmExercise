import sys
sys.setrecursionlimit(10**6)
import heapq

# 정점의 개수 V, 간선의 개수 E
V, E = map(int, sys.stdin.readline().split())

# 시작 정점의 번호
K = int(sys.stdin.readline())

INF = int(1e9)

# 그래프 초기화
graph = [[] * (V+1) for _ in range(V+1)]

distance = [INF] * (V+1)

# 간선 정보 입력
for _ in range(E):
    u, v, w = map(int, sys.stdin.readline().split())
    # u -> v가 w(가중치)
    graph[u].append((v, w))


def dijkstra(start):
    que = []
    # 시작 정점으로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
    heapq.heappush(que, (0, start))
    distance[start] = 0

    while que:
        # 가중치(가장 최단 거리)가 짧은 정점에 대한 값이 먼저 나옴
        dist, now = heapq.heappop(que)
        # 현재 정점이 이미 처리된 적이 있는 정점이라면 무시
        if distance[now] < dist:
            continue
            
        # 현재 정점과 연결된 다른 인접한 정점들을 확인
        for next in graph[now]:
            cost = dist + next[1]
            # 현재 정점을 거쳐서, 다른 정점으로 이동하는 거리가 더 짧은 경우
            if cost < distance[next[0]]:
                distance[next[0]] = cost
                heapq.heappush(que, (cost, next[0]))

# 다익스트라 알고리즘을 수행
dijkstra(K)

# 모든 노드로 가기 위한 최단 거리를 출력
for i in range(1, V+1):
    if distance[i] == INF:
        print('INF')
    else:
        print(distance[i])
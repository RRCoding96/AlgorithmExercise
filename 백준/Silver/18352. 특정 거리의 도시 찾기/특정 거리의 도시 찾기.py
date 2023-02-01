from collections import deque

import sys

# 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X
N, M, K, X = map(int, sys.stdin.readline().split())

towns = [[] for _ in range(N + 1)]
for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    towns[a].append(b)

distance = [-1] * (N + 1)
distance[X] = 0


def bfs(start):
    # global distance
    que = deque()

    que.append(start)

    while que:
        now = que.popleft()
        for t in range(len(towns[now])):
            next = towns[now][t]
            if distance[next] == -1:
                que.append(next)
                distance[next] = distance[now] + 1


bfs(X)

isIn = False
for i in range(1, len(distance)):
    if distance[i] == K:
        print(i)
        isIn = True

if isIn == False:
    print(-1)

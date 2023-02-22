import sys

def dfs(start):
    global answer, checked

    for nxt in graph[start]:
        if checked[nxt]:
            continue
        checked[nxt] = True
        answer += 1
        dfs(nxt)


T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    N, M = map(int, input().split())

    graph = [[] for _ in range(N + 1)]
    for _ in range(M):
        a, b = map(int, sys.stdin.readline().rstrip().split())
        graph[a].append(b)
        graph[b].append(a)
    #
    # checked = [False for _ in range(N + 1)]
    #
    # answer = 0
    # checked[1] = True
    # dfs(1)
    #
    # print(answer)

    print(N-1)

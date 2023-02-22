import sys
sys.setrecursionlimit(int(1e9))


def dfs(start, check):
    global graph, root

    for nxt in graph[start]:
        if check[nxt]:
            continue
        check[nxt] = True
        root[nxt] = start
        dfs(nxt, check)


N = int(sys.stdin.readline().rstrip())

graph = [[] for _ in range(N + 1)]

for _ in range(N - 1):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    graph[a].append(b)
    graph[b].append(a)

root = [0 for _ in range(N + 1)]

checked = [False for _ in range(N + 1)]
checked[1] = True
dfs(1, checked)

for i in range(2, N + 1):
    print(root[i])

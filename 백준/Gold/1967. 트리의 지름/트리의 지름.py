import sys
sys.setrecursionlimit(10**9)


def dfs(node, distance):
    global max_len_node, max_len, checked
    if node > n:
        return

    if len(graph[node]) == 1:
        if max_len < distance:
            max_len = distance
            max_len_node = node

    for nxt in graph[node]:
        if checked[nxt[0]]:
            continue
        checked[nxt[0]] = True
        dfs(nxt[0], distance + nxt[1])


n = int(sys.stdin.readline().rstrip())

graph = [[] for _ in range(n + 1)]

for _ in range(n-1):
    p, c, dist = map(int, sys.stdin.readline().rstrip().split())
    graph[p].append([c, dist])
    graph[c].append([p, dist])

# print(*graph, sep='\n')

max_len = 0
max_len_node = 0
checked = [False for _ in range(n + 1)]

checked[1] = True
dfs(1, 0)

a = max_len_node
a_len = max_len

max_len = 0
max_len_node = 0
checked = [False for _ in range(n + 1)]

checked[a] = True
dfs(a, 0)

b = max_len_node
b_len = max_len

print(b_len)
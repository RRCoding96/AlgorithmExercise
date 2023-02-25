import sys
sys.setrecursionlimit(10**9)

def dfs(node, distance):
    global max_dist, max_dist_node, checked

    if len(graph[node]) == 1:
        if max_dist < distance:
            max_dist = distance
            max_dist_node = node

    for nxt in graph[node]:
        if checked[nxt[0]]:
            continue
        checked[nxt[0]] = True
        dfs(nxt[0], distance + nxt[1])





V = int(sys.stdin.readline().rstrip())

graph = [[] for _ in range(V + 1)]

for _ in range(V):
    line = list(map(int, sys.stdin.readline().rstrip().split()))
    p = line[0]
    for i in range(1, len(line), 2):
        if line[i] == -1:
            break
        c = line[i]
        dist = line[i + 1]
        graph[p].append([c, dist])

# print(*graph, sep='\n')

max_dist = 0
max_dist_node = 0
checked = [False for _ in range(V + 1)]

checked[1] = True
dfs(1, 0)

# print(max_dist_node)
n_start = max_dist_node

max_dist = 0
max_dist_node = 0
checked = [False for _ in range(V + 1)]

checked[n_start] = True
dfs(n_start, 0)

print(max_dist)


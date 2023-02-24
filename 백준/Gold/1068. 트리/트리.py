import sys


def find_leaf(node):
    global answer, checked, delete_node

    if node == delete_node:
        return

    if len(graph[node]) == 0:
        # print('leaf: ', node)
        answer += 1
        return

    for nxt in graph[node]:
        if checked[nxt]:
            continue

        checked[nxt] = True
        find_leaf(nxt)


N = int(sys.stdin.readline().rstrip())

tree = list(map(int, sys.stdin.readline().rstrip().split()))
root = -1

graph = [[] for _ in range(N + 1)]
for node in range(N):
    p = tree[node]

    if p == -1:
        root = node
        continue

    graph[p].append(node)

# print('root: ', root)
# print(*graph, sep='\n')
# print()

delete_node = int(sys.stdin.readline().rstrip())
graph[delete_node] = []

for g in graph:
    if delete_node in g:
        g.remove(delete_node)

# print(*graph, sep='\n')
# print()

checked = [False for _ in range(N)]
answer = 0

checked[root] = True
find_leaf(root)

print(answer)

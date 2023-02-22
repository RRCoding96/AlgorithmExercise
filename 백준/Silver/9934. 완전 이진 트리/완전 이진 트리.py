import sys

sys.setrecursionlimit(int(1e9))


def make_tree(start, end, level):
    global tree

    if start == end:
        tree[level].append(arr[start])
        return

    mid = (start + end) // 2

    tree[level].append(arr[mid])
    make_tree(start, mid - 1, level + 1)
    make_tree(mid + 1, end, level + 1)


K = int(sys.stdin.readline().rstrip())

arr = list(map(int, sys.stdin.readline().rstrip().split()))
tree = [[] for _ in range(K)]

make_tree(0, len(arr) - 1, 0)

for t in tree:
    for v in t:
        print(v, end=' ')
    print()

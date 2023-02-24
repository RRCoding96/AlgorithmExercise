import sys, copy


def vlr(node):
    print(node, end='')
    if left[node] == '.' and right[node] == '.':
        return

    if left[node] != '.':
        vlr(left[node])
    if right[node] != '.':
        vlr(right[node])


def lvr(node):
    if left[node] != '.':
        lvr(left[node])

    print(node, end='')

    if right[node] != '.':
        lvr(right[node])


def lrv(node):
    if left[node] != '.':
        lrv(left[node])

    if right[node] != '.':
        lrv(right[node])

    print(node, end='')


N = int(sys.stdin.readline().rstrip())

left = dict()
right = dict()
# checked = dict()

for _ in range(N):
    n, l, r = map(str, sys.stdin.readline().rstrip().split())

    left[n] = l
    right[n] = r
    # checked[n] = False

vlr('A')
print()

# lvr_checked = copy.deepcopy(checked)
lvr('A')
print()

lrv('A')

import sys
from collections import deque

def check_right(start, dirs):
    if start > 4 or chains[start-1][2] == chains[start][6]:
        return

    if chains[start-1][2] != chains[start][6]:
        check_right(start+1, -dirs)
        chains[start].rotate(dirs)

def check_left(start, dirs):
    if start < 1 or chains[start][2] == chains[start+1][6]:
        return

    if chains[start+1][6] != chains[start][2]:
        check_left(start-1, -dirs)
        chains[start].rotate(dirs)

chains = dict()

for i in range(1, 5):
    chains[i] = deque(list(map(int, list(sys.stdin.readline().replace('\n', '')))))

K = int(sys.stdin.readline())
for _ in range(K):
    num, dirs = map(int, sys.stdin.readline().split())

    check_right(num+1, -dirs)
    check_left(num-1, -dirs)

    chains[num].rotate(dirs)

result = 0
for i in range(4):
    result += (2**i) * chains[i+1][0]
print(result)




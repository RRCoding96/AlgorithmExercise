from collections import deque

n, k = map(int, input().split())

que = deque(i for i in range(1, n + 1))

result = []

while que:
    for _ in range(k-1):
        if len(que) > 0:
            que.append(que.popleft())

    result.append(que.popleft())

print('<', end='')
for i in range(n-1):
    print(f'{result[i]}, ', end='')
print(result[n-1], end='')
print('>')

N = int(input())

answer = 0
for _ in range(N):
    n_stack = [0]
    root = list(input())
    for c in root:
        if n_stack[-1] == c:
            n_stack.pop()
        else:
            n_stack.append(c)
    if len(n_stack) == 1:
        answer += 1

print(answer)

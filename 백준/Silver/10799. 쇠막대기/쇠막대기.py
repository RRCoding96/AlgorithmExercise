import sys

line = list(sys.stdin.readline().rstrip())

stack = []
answer = 0
for i in range(len(line)):
    if line[i] == '(':
        stack.append('(')
    else:
        if line[i-1] == '(':
            stack.pop()
            answer += len(stack)
        else:
            stack.pop()
            answer += 1

print(answer)

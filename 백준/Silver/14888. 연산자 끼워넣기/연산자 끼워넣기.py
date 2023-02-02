

N = int(input())
numbers = list(map(int, input().split()))
add, sub, mul, div = map(int, input().split())


max_ = -1e9
min_ = 1e9

def dfs(i, now):
    global min_, max_, add, sub, mul, div

    if i == N:
        min_ = min(min_, now)
        max_ = max(max_, now)
        return

    if add > 0:
        add -= 1
        dfs(i + 1, now + numbers[i])
        add += 1
    if sub > 0:
        sub -= 1
        dfs(i + 1, now - numbers[i])
        sub += 1
    if mul > 0:
        mul -= 1
        dfs(i + 1, now * numbers[i])
        mul += 1
    if div > 0:
        div -= 1
        dfs(i + 1, int(now / numbers[i]))
        div += 1

dfs(1, numbers[0])
print(max_)
print(min_)

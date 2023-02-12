import sys

N = int(sys.stdin.readline().rstrip())

arr = []
for _ in range(N):
    value = sys.stdin.readline().rstrip()
    sum_num = 0
    for c in value:
        if not (c.isalpha()):
            sum_num += int(c)
    arr.append(list([len(value), sum_num, value]))

arr.sort(key=lambda x: (x[0], x[1], x[2]))

for i in range(N):
    print(arr[i][2])


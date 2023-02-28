import sys

n = int(sys.stdin.readline().rstrip())
arr = list(map(int, sys.stdin.readline().rstrip().split()))

sum_arr = [0] * n
# [값, 인덱스]
answer = arr[0]

sum_arr[0] = arr[0]
min_value = arr[0]
for i in range(1, n):
    sum_arr[i] = sum_arr[i - 1] + arr[i]
    if min_value > sum_arr[i]:
        min_value = sum_arr[i]
    else:
        answer = max(answer, sum_arr[i] - min_value, sum_arr[i], arr[i])
    answer = max(answer, sum_arr[i], arr[i])

# print(sum_arr)
print(answer)

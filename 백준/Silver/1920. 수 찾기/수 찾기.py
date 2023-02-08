import sys


def binary_search(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return 1
        elif target > array[mid]:
            start = mid + 1
        else:
            end = mid - 1

    return 0


N = int(sys.stdin.readline().rstrip())
arr = list(map(int, sys.stdin.readline().rstrip().split()))

M = int(sys.stdin.readline().rstrip())
targets = list(map(int, sys.stdin.readline().rstrip().split()))

arr.sort()

for n in targets:
    print(binary_search(arr, n, 0, N - 1))

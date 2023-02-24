import sys

sys.setrecursionlimit(10 ** 9)


def lrv(start, end):
    if start > end:
        return

    mid = end + 1

    for i in range(start + 1, end + 1):
        if arr[start] < arr[i]:
            mid = i
            break

    lrv(start + 1, mid - 1)
    lrv(mid, end)
    print(arr[start])


arr = []
while True:
    try:
        n = input()
        arr.append(int(n))
    except:
        break

# print(arr)

N = len(arr)
lrv(0, N - 1)

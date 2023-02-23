# from collections import deque
#
#
# def bfs():
#     l = 0
#     r = 0
#     que = deque()
#
#     que.append([1, 1, 1, l, r])
#     while que:
#         idx, x, y, left, right = que.popleft()
#
#         if x == a and y == b:
#             return left, right
#
#         n_left = 2 * idx
#         que.append([n_left, x + y, y, left + 1, right])
#         n_right = 2 * idx + 1
#         que.append([n_right, x, x + y, left, right + 1])


a, b = map(int, input().split())

# tree_arr = [[] for _ in range((a + b) * 3)]

# tree_arr[1] = [1, 1]

ans_left = 0
ans_right = 0

# while True:
#
#     if a == 1 and b == 1:
#         break
#
#     if a < b:
#         ans_right += 1
#         a = a
#         b = b - a
#     elif a > b:
#         ans_left += 1
#         a = a - b
#         b = b

while a > 1 and b > 1:
    if a > b:
        ans_left += a // b
        a %= b
    else:
        ans_right += b // a
        b %= a

ans_left += a - 1
ans_right += b - 1


print(ans_left, ans_right)

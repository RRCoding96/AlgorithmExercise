import sys
from collections import deque

n, w, L = map(int, sys.stdin.readline().split())

cars = deque(map(int, sys.stdin.readline().split()))

# 자동차 덩어리 만들기

# 덩어리 마지막 자동차 기준으로 건너는 시간 구하기
result = 0
bridge = deque()
for _ in range(w):
    bridge.append(0)

# print(bridge)

while True:
    if len(cars) == 0 and sum(bridge) == 0:
        break

    if len(cars) > 0:
        last_car = cars[0]
    else:
        last_car = 0

    bridge.popleft()
    total_weight = sum(bridge)

    if total_weight + last_car > L:
        result += 1
        bridge.append(0)

    else:
        result += 1
        if len(cars) > 0:
            cars.popleft()

        bridge.append(last_car)

    # print(bridge)



# while len(cars) > 0:
#
#     total_weight = 0
#     car_cnt = 0
#     while total_weight <= L:
#         if len(cars) <= 0:
#             break
#
#         total_weight += cars.popleft()
#         car_cnt += 1
#
#     result += w + car_cnt
#     if car_cnt > 1:
#         result += w + car_cnt
#     else:
#         result += w + 1

print(result)

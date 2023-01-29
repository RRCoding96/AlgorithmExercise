from itertools import combinations
import sys

N, M = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]

chickens = []
for i in range(N):
    for j in range(N):
        if board[i][j] == 2:
            chickens.append([i, j])

house = []
for i in range(N):
    for j in range(N):
        if board[i][j] == 1:
            house.append([i, j])


result = sys.maxsize
combies = list(combinations(chickens, M))

for case in combies:
    dir_sum = 0

    for home in house:
        homeX = home[0]
        homeY = home[1]
        dir_min = sys.maxsize
        for chicken in case:
            chickenX = chicken[0]
            chickenY = chicken[1]
            dir_min = min(dir_min, abs(chickenX - homeX) + abs(chickenY - homeY))

        dir_sum += dir_min
    result = min(result, dir_sum)

print(result)




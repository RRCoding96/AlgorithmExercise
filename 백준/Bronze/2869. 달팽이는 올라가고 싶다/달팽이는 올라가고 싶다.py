import math

up, down, height = map(int, input().split())

move = up - down
nHeight = height - up

day = nHeight / move

print(math.ceil(day) + 1)



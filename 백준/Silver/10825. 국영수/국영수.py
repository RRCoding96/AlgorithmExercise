N = int(input())

result = []
for _ in range(N):
    list_ = list(input().split())
    result.append([list_[0], int(list_[1]), int(list_[2]), int(list_[3])])

result.sort(key=lambda a : (-a[1], a[2], -a[3], a[0]))

for i in range(N):
    print(result[i][0])
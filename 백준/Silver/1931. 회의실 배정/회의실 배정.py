N = int(input())

meetings = list()
for i in range(N):
    meetings.append(list(map(int, input().split())))

meetings.sort(key=lambda a:(a[1], a[0]))

start = 0
end = 0
result = 0
for meeting in meetings:
    if meeting[0] >= end:
        result += 1
        end = meeting[1]

print(result)
K, N = map(int, input().split()) # K: 이미 가지고 있는 랜선 개수, N: 필요한 랜선 개수

lines = list()
for i in range(K):
    lines.append(int(input()))

lines.sort()
mMin = 1
mMax = lines[len(lines) - 1]

cnt = 0 # 랜선 개수

while mMin <= mMax:
    cnt = 0  # 랜선 개수
    mid = (mMin + mMax) // 2  # 중간값
    for line in lines:
        cnt += line // mid

    if cnt >= N: # 랜선 개수가 큼(많이 잘림) -> 랜선이 짧음 (최대 길이 찾아야 됨)
        mMin = mid + 1
    else: # 랜선 개수가 작음(적게 잘림) -> 랜선이 긺
        mMax = mid - 1


print(mMin - 1)

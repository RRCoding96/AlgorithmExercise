def get_cost(k):
    return k * k + (k - 1) * (k - 1)


T = int(input())
for tc in range(1, T + 1):
    N, M = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(N)]
    
    homes = []  # 집 좌표

    for i in range(N):
        for j in range(N):
            if board[i][j] == 1:  # 집 위치 넣기
                homes.append([i, j])

    house_cnt = 0
    for i in range(N):
        for j in range(N):
            # 중심 좌표에서 떨어진 거리(인덱스)에 집이 몇 개 있는지 넣음
            dist = [0] * (2 * N)
            for x, y in homes:
                dist[abs(i - x) + abs(j - y)] += 1
            # 그 거리 안에는 다 포함됨
            for k in range(1, 2 * N):
                dist[k] += dist[k - 1]

            # 거리가 1부터 2N까지
            for k in range(0, 2 * N):
                # 적자가 아닐 때
                if dist[k] * M - get_cost(k + 1) >= 0:
                    house_cnt = max(house_cnt, dist[k])

    print(f'#{tc}', house_cnt)

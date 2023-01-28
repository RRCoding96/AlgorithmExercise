from collections import deque


def turn_key(key):
    M = len(key)
    que = deque()
    nKey = [[0 for _ in range(M)] for _ in range(M)]
    for i in range(M):
        for j in range(M):
            que.append(key[i][j])

    for j in range(M-1, -1, -1):
        for i in range(0, M):
            nKey[i][j] = que.popleft()
    return nKey


def solution(key, lock):
    N = len(lock)
    M = len(key)
    answer = False

    lock_pos = []
    for i in range(N):
        for j in range(N):
            if lock[i][j] == 0:
                lock_pos.append([i, j])


    turn_cnt = 0

    while turn_cnt < 4:
        key_pos = []
        for i in range(M):
            for j in range(M):
                if key[i][j] == 1:
                    key_pos.append([i, j])
        key_pos.sort()
        # key 가장 오른쪽 위치를 (0,0)에 맞춰줌
        rx = key_pos[-1][0]
        ry = key_pos[-1][0]
        # 키 위치를 전부 왼쪽 가장 위로 밀어줌
        for i in range(len(key_pos)):
            key_pos[i][0] = key_pos[i][0] - rx
            key_pos[i][1] = key_pos[i][1] - ry

        for i in range(N + M):
            for j in range(N + M):
                n_key_pos = []
                for k in range(len(key_pos)):
                    nowkx = key_pos[k][0] + i
                    nowky = key_pos[k][1] + j
                    if nowkx < 0 or nowky < 0 or nowkx >= N or nowky >= N:
                        continue
                    n_key_pos.append([nowkx, nowky])
                n_key_pos.sort()
                if n_key_pos == lock_pos:
                    return True

        key = turn_key(key)
        turn_cnt += 1



    return answer
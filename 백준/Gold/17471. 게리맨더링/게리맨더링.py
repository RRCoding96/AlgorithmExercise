import sys
from collections import deque


def check_valid_section(A, B):
    global N, graph

    visited = [False for _ in range(N + 1)]
    # 첫번째 덩어리 체크
    queA = deque()
    queA.append(A[0])
    visited[A[0]] = True

    while queA:
        now = queA.popleft()

        for nxt in graph[now]:
            if visited[nxt]:
                continue
            if nxt in A:
                queA.append(nxt)
                visited[nxt] = True

    for c in A:
        if not visited[c]:
            return False

    # 두번째 덩어리 체크
    queB = deque()

    queB.append(B[0])
    visited[B[0]] = True

    while queB:
        now = queB.popleft()

        for nxt in graph[now]:
            if visited[nxt]:
                continue
            if nxt in B:
                queB.append(nxt)
                visited[nxt] = True

    for c in B:
        if not visited[c]:
            return False

    return True


def make_combination(depth, target_size, chunk, start, check):
    global N, population, result
    if depth == target_size:
        # 유효한 조합인지 확인
        other_chunk = [i for i in range(1, N + 1)]
        for n in chunk:
            other_chunk.remove(n)

        valid_sep = check_valid_section(chunk, other_chunk)
        # 유효한 조합이라면 인구 차이 구하기
        if valid_sep:
            sum_A = 0
            sum_B = 0
            for n in chunk:
                sum_A += population[n]
            for n in other_chunk:
                sum_B += population[n]

            diff = abs(sum_A - sum_B)
            if result > diff:
                result = diff

        return

    for i in range(start, N + 1):
        if not check[i]:
            chunk.append(i)
            check[i] = True

            make_combination(depth + 1, target_size, chunk, i, check)

            chunk.pop()
            check[i] = False


N = int(sys.stdin.readline().rstrip())
population = [0]
graph = graph = [[] for _ in range(N + 1)]
result = int(1e9)


def solution():
    popu_temp = list(map(int, sys.stdin.readline().rstrip().split()))
    for n in popu_temp:
        population.append(n)

    for i in range(N):
        link = list(map(int, sys.stdin.readline().rstrip().split()))
        for j in range(1, link[0] + 1):
            graph[i + 1].append(link[j])

    # 선거구 조합 만들어서 탐색
    checked = [False for _ in range(N + 1)]
    for i in range(1, N // 2 + 1):
        comb = []
        make_combination(0, i, comb, 1, checked)

        # 탐색하면서 유효한지 확인
        # 유효한 조합이라면 인구 차이 구하기
    if result == int(1e9):
        print(-1)
    else:
        print(result)


solution()

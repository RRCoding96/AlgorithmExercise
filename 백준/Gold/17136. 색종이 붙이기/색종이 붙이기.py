import sys
sys.setrecursionlimit(10 ** 6)

paper = [list(map(int, sys.stdin.readline().split())) for _ in range(10)]
remain = [5, 5, 5, 5, 5]
total = 25


# 현재 종이 크기로 붙일 수 있는지 확인
def check(x, y, length):
    for i in range(x, x + length + 1):
        for j in range(y, y + length + 1):
            if paper[i][j] != 1:
                return False
    return True


def backtracking(r, c, paper_cnt):
    global remain, total

    # 종이 맨 밑 까지 도달 하면
    if r >= 10:
        total = min(total, paper_cnt)
        return
    
    # 종이 오른쪽 끝까지 가면 바로 아래 줄 부터 검사
    if c >= 10:
        backtracking(r + 1, 0, paper_cnt)
        return
    
    # 현재 위치에 종이 붙일 수 있으면
    if paper[r][c] == 1:
        # 종이 크기 1부터
        for k in range(5):
            # 현재 크기 종이를 이미 다 썼는지 확인
            if remain[k] == 0:
                continue
            # 현재 크기의 종이를 붙였을 때 범위 벗어나는지 확인
            if r + k >= 10 or c + k >= 10:
                continue
            
            # 중간에 0인 부분 나오는지 확인
            # 나오면 이 크기와 더 큰 종이는 못 붙임
            if not check(r, c, k):
                break
            
            # 해당 종이 크기를 붙인 상태로 갱신
            for i in range(r, r + k + 1):
                for j in range(c, c + k + 1):
                    paper[i][j] = 0
            # 현재 크기 개수 1 줄이기
            remain[k] -= 1

            # 다음 부분 탐색(오른쪽으로 다음 부분)
            backtracking(r, c + k + 1, paper_cnt + 1)
            
            # 다시 원상 복귀
            remain[k] += 1
            for i in range(r, r + k + 1):
                for j in range(c, c + k + 1):
                    paper[i][j] = 1
    # 현재 위치에 종이 못 붙이면 다음 칸(오른쪽) 확인
    else:
        backtracking(r, c + 1, paper_cnt)


backtracking(0, 0, 0)
print(-1 if total == 25 else total)

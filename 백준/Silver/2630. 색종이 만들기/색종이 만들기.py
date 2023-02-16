import sys

N = int(sys.stdin.readline().rstrip())

board = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]
result = 0
blue = 0


def separate(sr, sc, er, ec):
    global result, board, N, blue
    # print(sr, sc, er, ec, '재귀호출됨')

    if sr == er and sc == ec:
        # print('1장짜리')
        # print(sr, sc)
        if board[sr][sc] == 1:
            blue += 1
        result += 1
        return

    temp = board[sr][sc]
    flag = True
    for i in range(sr, er + 1):
        for j in range(sc, ec + 1):
            if board[i][j] != temp:
                flag = False
                break
    if flag:
        # print('여러 장인데 끝')
        # print(sr, sc, er, ec)
        if temp == 1:
            blue += 1
        result += 1
        return
    else:
        midR = (sr + er) // 2
        midC = (sc + ec) // 2

        separate(sr, sc, midR, midC)
        separate(sr, midC + 1, midR, ec)
        separate(midR + 1, sc, er, midC)
        separate(midR + 1, midC + 1, er, ec)


def solution():
    global N, board, result, blue

    separate(0, 0, N - 1, N - 1)

    print(result - blue)
    print(blue)


solution()

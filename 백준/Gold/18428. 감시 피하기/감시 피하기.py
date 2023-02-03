
def check_t_sight(plain_board):
    t_sight = [[False for _ in range(N)] for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if plain_board[i][j] == 'T':
                # 세로로 시야 체크
                for a in range(i-1, -1, -1):
                    if plain_board[a][j] == 'O':
                        break
                    t_sight[a][j] = True
                for a in range(i+1, N, 1):
                    if plain_board[a][j] == 'O':
                        break
                    t_sight[a][j] = True
                for b in range(j-1, -1, -1):
                    if plain_board[i][b] == 'O':
                        break
                    t_sight[i][b] = True
                for b in range(j+1, N, 1):
                    if plain_board[i][b] == 'O':
                        break
                    t_sight[i][b] = True

    return t_sight

def make_object_case(depth, sight_board, n_board, o_pos):
    global board
    global s_pos
    global check
    if depth == 3:
        # 새로운 teacher 시야 체크
        n_t_sight = check_t_sight(n_board)
        # 시야 안에 학생 있는지 체크
        for pos in s_pos:
            if n_t_sight[pos[0]][pos[1]]:
                check.append(False)
                return

        check.append(True)
        return

    for i in range(N):
        for j in range(N):
            if board[i][j] == 'X' and sight_board[i][j] == True:
                n_board[i][j] = 'O'
                o_pos.append([i, j])

                make_object_case(depth+1, sight_board, n_board, o_pos)

                o_pos.pop()
                n_board[i][j] = 'X'


N = int(input())
board = [list(map(str, input().split())) for _ in range(N)]

# print(*board, sep='\n')

# teacher 시야 체크
plain_sight = check_t_sight(board)

# 학생 좌표
s_pos = []
for i in range(N):
    for j in range(N):
        if board[i][j] == 'S':
            s_pos.append([i, j])
# teacher 시야 안에 Object 3개 놔서 학생 자리에 True가 없도록
check = []
o_pos = []
make_object_case(0, plain_sight, board, o_pos)

if True in check:
    print('YES')
else:
    print('NO')

def solution(board, skill):
    answer = 0
    row_len = len(board)
    col_len = len(board[0])

    check = [[0 for _ in range(col_len + 1)] for _ in range(row_len + 1)]
    for command in skill:
        attack, r1, c1, r2, c2, degree = command
        # 적 공격 -> -degree
        if attack == 1:
            check[r1][c1] -= degree
            check[r2 + 1][c2 + 1] -= degree
            check[r2 + 1][c1] += degree
            check[r1][c2 + 1] += degree
        # 아군 힐 -> +degree
        elif attack == 2:
            check[r1][c1] += degree
            check[r2 + 1][c2 + 1] += degree
            check[r2 + 1][c1] -= degree
            check[r1][c2 + 1] -= degree

    for i in range(row_len):
        for j in range(col_len):
            check[i+1][j] += check[i][j]

    for j in range(col_len):
        for i in range(row_len):
            check[i][j+1] += check[i][j]

    for i in range(row_len):
        for j in range(col_len):
            value = board[i][j] + check[i][j]
            if value > 0:
                answer += 1

    return answer
def solution(board):
    answer = 0
    
    dx = [0, 0, -1, 1, 1, 1, -1, -1]
    dy = [1, -1, 0, 0, 1, -1, 1, -1]
    
    nBoard = [[0 for j in range(len(board))] for i in range(len(board))]
    for i in range(len(board)):
        for j in range(len(board[i])):
            if board[i][j] == 1:
                nBoard[i][j] = 1
                for t in range(8):
                    nx = i + dx[t]
                    ny = j + dy[t]
                    
                    if nx < 0 or ny < 0 or nx >= len(board) or ny >= len(board):
                        continue
                    
                    nBoard[nx][ny] = 1
             
    for i in range(len(board)):
        for j in range(len(board[i])):
            if nBoard[i][j] == 0:
                answer += 1
    
    return answer
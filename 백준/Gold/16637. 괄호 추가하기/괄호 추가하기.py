# 문자열로 계산하기
def calculate(num1, num2, paren):
    if paren == '+':
        return num1 + num2
    elif paren == '-':
        return num1 - num2
    else:
        return num1 * num2


def dfs(index, value):
    global result

    # 마지막까지 왔으면 계산해서 최대값 저장 후 종료
    if index == N - 1:
        result = max(result, value)
        return

    # 짝수번째 -> 숫자, 홀수번째 -> 연산자
    # 바로 다음 숫자와 연산(괄호 안 씀)
    if index + 2 < N:
        # 현재 값, 다음 숫자 연산
        nNum = calculate(value, int(line[index + 2]), line[index + 1]) 
        dfs(index + 2, nNum)

    # 괄호로 묶고 다음 숫자, 다다음 숫자를 연산한 결과와 연산
    if index + 4 < N:
        # 다음 숫자, 다다음 숫자 연산한 결과
        temp = calculate(int(line[index + 2]), int(line[index + 4]), line[index + 3])
        # 현재 값, 위에 구한 결과 연산
        nNum = calculate(value, temp, line[index + 1])
        dfs(index + 4, nNum)


N = int(input())
line = list(input())

# 처음엔 젤 작은 숫자 넣어둠
result = int(-1e9)

# 재귀 시작
dfs(0, int(line[0]))

print(result)
